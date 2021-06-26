package com.example.demo;

import config.CurrentUserSession;
import config.Products;
import config.Users;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CaseStudyService {


    public void loadData() throws IOException {
        List<String> productStrList = Files.readAllLines(Paths.get("src/main/resources/Products.txt"));
        List<Products> productsList = convertToProducts(productStrList, ",");
        List<String> currentUserSessionStrList = Files.readAllLines(Paths.get("src/main/resources/CurrentUserSession.txt"));
        List<CurrentUserSession> currentUserSessionList = convertToCurrentUserSession(currentUserSessionStrList);
        List<String> usersStrList = Files.readAllLines(Paths.get("src/main/resources/Users.txt"));
        List<Users> usersList = convertToUsers(usersStrList, productsList);
        recentPopularProductsHashmap(usersList, productsList);
        recommendedProducts(currentUserSessionList.get(0), productsList);
    }

    private List<Users> convertToUsers(List<String> usersStrList, List<Products> productsList) {
        List<Users> usersList = new ArrayList<>();
        for (String usersStr : usersStrList) {
            String[] usersArr = usersStr.split(",");
            usersList.add(new Users(Integer.parseInt(usersArr[0]), usersArr[1], getProductsFromIds(usersArr[2].split(";"), productsList),
                    getProductsFromIds(usersArr[3].split(";"), productsList)));
        }
        return usersList;
    }

    private List<CurrentUserSession> convertToCurrentUserSession(List<String> currentUserSessionStrList) {
        List<CurrentUserSession> currentUserSessionList = new ArrayList<>();
        for (String currentUserSessionStr : currentUserSessionStrList) {
            String[] currentUserSessionArray = currentUserSessionStr.split(",");
            currentUserSessionList.add(new CurrentUserSession(Integer.parseInt(currentUserSessionArray[0].trim()), Integer.parseInt(currentUserSessionArray[1].trim())));
        }
        return currentUserSessionList;

    }

    private List<Products> convertToProducts(List<String> productStrList, String regex) {
        List<Products> productsList = new ArrayList<>();
        for (String productStr : productStrList) {
            String[] productArray = productStr.split(regex);
            if (productArray.length != 10) {
                //throw error
            }
            productsList.add(new Products(Integer.parseInt(productArray[0]), productArray[1], Integer.parseInt(productArray[2]), productArray[3], productArray[4],productArray[5],
                    productArray[6],productArray[7], Double.parseDouble(productArray[8]), Integer.parseInt(productArray[9]), 0));
        }
        return productsList;
    }

    private List<Products> getProductsFromIds(String[] productIdsList, List<Products> productsList) {
        List<Products> productsListFromIds = new ArrayList<>();
        for(String productId: productIdsList) {
            //TODO Get it using the actual ID instead of array index
            productsListFromIds.add(productsList.get(Integer.parseInt(productId.trim())-1));
        }
        return productsListFromIds;
    }

    private List<Products> recentPopularProducts(List<Users> usersList) {
        List<Products> popularProductsList = new ArrayList<>();
        for (Users users: usersList) {
            popularProductsList = users.getProductsPurchased().stream().map(product -> {
                Integer incrCount = product.getCount() + 1;
                product.setCount(incrCount);
                return product;
            }).sorted(Comparator.comparingInt(Products::getCount).reversed()).collect(Collectors.toList());
        }
        return popularProductsList;
    }

    private List<Products> recentPopularProductsOld(List<Users> usersList) {
        List<Products> popularProductsList = new ArrayList<>();
        for (Users users: usersList) {
            for (Products products: users.getProductsPurchased()){
                Integer count  = products.getCount();
                products.setCount(count + 1);
                popularProductsList.add(products);
            }
        }
        popularProductsList.sort(Comparator.comparingInt(Products::getCount).reversed());
        return popularProductsList;
    }

    private List<Products> recentPopularProductsHashmap(List<Users> usersList, List<Products> productsList) {
        Map<Integer, Integer> popularProductsMap = new HashMap<>();
        List<Products> popularProductsList = new ArrayList<>();
        for (Users users: usersList) {
            for (Products products: users.getProductsPurchased()){
                int count = 1;
                if (popularProductsMap.get(products.getProductId()) != null) {
                    count = popularProductsMap.get(products.getProductId()) + 1;
                }
                popularProductsMap.put(products.getProductId(), count);
            }
        }
        popularProductsMap.forEach((k, v) -> {
            //TODO Get based on actual id instead of array index
            Products products = productsList.get(k);
            products.setCount(v);
            popularProductsList.add(products);
        });
        popularProductsList.sort(Comparator.comparingInt(Products::getCount).reversed());
        return popularProductsList;
    }

    private List<Products> recentPopularProductsHashmapStreams(List<Users> usersList, List<Products> productsList) {
        Map<Integer, Integer> popularProductsMap = new HashMap<>();
        List<Products> popularProductsList = new ArrayList<>();
        for (Users users: usersList) {
            for (Products products: users.getProductsPurchased()){
                int count = 1;
                if (popularProductsMap.get(products.getProductId()) != null) {
                    count = popularProductsMap.get(products.getProductId()) + 1;
                }
                popularProductsMap.put(products.getProductId(), count);
            }
        }
        popularProductsMap.forEach((k, v) -> {
            //TODO Get based on actual id instead of array index
            Products products = productsList.get(k);
            products.setCount(v);
            popularProductsList.add(products);
        });
        popularProductsList.sort(Comparator.comparingInt(Products::getCount).reversed());
        return popularProductsList;
    }

    private List<Products> recommendedProducts(CurrentUserSession currentUserSession, List<Products> productsList) {
        List<Products> recommendedProductsList = new ArrayList<>();
        Map<Integer, Integer> recommendedProductsMap = new HashMap<>();
        Products product = productsList.get(currentUserSession.getProductId());
        for (Products productB : productsList) {
            if (productB.getKeyword1().equalsIgnoreCase(product.getKeyword1())) {
                int count = 1;
                if (recommendedProductsMap.get(productB.getProductId()) != null) {
                    count = recommendedProductsMap.get(productB.getProductId()) +1 ;
                }
                recommendedProductsMap.put(productB.getProductId(), count);
            }
        }
        recommendedProductsMap.forEach((k, v) -> {
            //TODO Get based on actual id instead of array index
            Products products = productsList.get(k);
            products.setCount(v);
            recommendedProductsList.add(products);
        });
        recommendedProductsList.sort(Comparator.comparingInt(Products::getCount).reversed());
        return recommendedProductsList;
    }
}
