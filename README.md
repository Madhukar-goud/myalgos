This is my personal workspace

@startuml
rectangle "Services Flow Architecture" {
    rectangle "Services Examples" as Services {
      ["queue service server"] as qss
      ["queue service consumer"] as qsc
      ["queue worker"] as qw
      ["notifications"] as notify

      qss -[hidden]down-> qsc
      qsc -[hidden]down-> qw
      qw -[hidden]down-> notify
    }

    rectangle "AWS ActiveMQ" {
        queue "events queue" as eq
        queue "events topic" as et
    }
    qss -> eq
    qsc -> eq
    notify -> eq
    qw -> eq

    eq -up-> et
}

@enduml
