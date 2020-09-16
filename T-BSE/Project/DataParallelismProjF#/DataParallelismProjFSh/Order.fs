module Order
open Store
open Date
open Supplier

type Order(store:Store, date:Date, supplier:Supplier, price:double) = 
    member this.store = store
    member this.date = date
    member this.supplier = supplier
    member this.price = price