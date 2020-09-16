module Supplier

type Supplier(supplierName:string, supplierType:string) = 
    member this.supplierName = supplierName
    member this.supplierType = supplierType