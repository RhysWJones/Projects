module Store

type Store(storeCode:string, storeName:string) = 
    member this.storeCode = storeCode
    member this.storeName = storeName