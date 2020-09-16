
open System
open Date
open Store
open Supplier
open Order
open System.Collections.Concurrent
open System.Collections.Generic
open System.IO
open System.Linq
open System.Diagnostics
open System.Threading.Tasks
open System.Threading

    let displayStores(orders:HashSet<Order>) =
        System.Console.Clear()
        let stores = orders.GroupBy(fun order -> order.store).Select(fun order -> order.Key).ToArray()
        let mutable count = 0
        if stores.Length > 0 then
            for store in stores do
                printf "%-s " store.storeCode
                printf "%-20s" store.storeName
                count <- count + 1
                if count = 3 then
                    count <- 0
                    printf "\n"
            printfn "\nPress any key to continue..."
            System.Console.ReadKey() |> ignore
        stores

    let displaySuppliers(orders:HashSet<Order>) =
        System.Console.Clear()
        let suppliers = orders.GroupBy(fun order -> order.supplier.supplierName).Select(fun order -> order.Key).ToArray()
        let mutable count = 0
        if suppliers.Length > 0 then
            for supplier in suppliers do
                printf "%-20s" supplier
                count <- count + 1
                if count = 3 then
                    count <- 0
                    printf "\n"
            printfn "\nPress any key to continue..."
            System.Console.ReadKey() |> ignore
        suppliers

    let displaySupplierTypes(orders:HashSet<Order>) =
        System.Console.Clear()
        let supplierTypes = orders.GroupBy(fun order -> order.supplier.supplierType).Select(fun order -> order.Key).ToArray()
        let mutable count = 0
        if supplierTypes.Length > 0 then
            for supplierType in supplierTypes do
                printf "%-25s" supplierType
                count <- count + 1
                if count = 3 then
                    count <- 0
                    printf "\n"
            printfn "\nPress any key to continue..."
            System.Console.ReadKey() |> ignore
        supplierTypes

    let displayDates(orders:HashSet<Order>) =
        System.Console.Clear()
        let dates = orders.GroupBy(fun order -> order.date).Select(fun order -> order.Key).ToArray()
        let mutable count = 0
        if dates.Length > 0 then
            for date in dates do
                printf "Week: %-i Year: %-10i" date.week date.year
                count <- count + 1
                if count = 3 then
                    count <- 0
                    printf "\n"
            printfn "\nPress any key to continue..."
            System.Console.ReadKey() |> ignore
        dates

    let getTotalCost(orders:HashSet<Order>) =
        System.Console.Clear()
        let totalCost = orders.Sum(fun order -> order.price)
        printf "Total cost for all orders = %s" (System.String.Format("£{0:#,0.00}", totalCost))
        System.Console.ReadKey() |> ignore

    let getTotalCostForStore(orders:HashSet<Order>) =
        System.Console.Clear()
        displayStores(orders) |> ignore
        printf "Input store code: "
        let storeCode = System.Console.ReadLine()
        let totalCostForStore = orders.Where(fun order -> order.store.storeCode.Equals(storeCode)).Sum(fun order -> order.price)
        printf "Total cost for all orders for store %-s: %-s" storeCode (System.String.Format("£{0:#,0.00}", totalCostForStore))
        System.Console.ReadKey() |> ignore

    let getTotalCostInWeek(orders:HashSet<Order>) = 
        System.Console.Clear()
        displayDates(orders) |> ignore
        printf "Input week: "
        let week = int32(System.Console.ReadLine())
        printf "Input Year: "
        let year = int32(System.Console.ReadLine())
        let totalCostInWeek = orders.Where(fun order -> order.date.week.Equals(week) && order.date.year.Equals(year)).Sum(fun order -> order.price)
        printf "Total cost for all orders in week %-i of year %-i: %-s" week year (System.String.Format("£{0:#,0.00}", totalCostInWeek))
        System.Console.ReadKey() |> ignore

    let getTotalCostInWeekForStore(orders:HashSet<Order>) =
        System.Console.Clear()
        displayDates(orders) |> ignore
        printf "Input week: "
        let week = int32(System.Console.ReadLine())
        printf "Input Year: "
        let year = int32(System.Console.ReadLine())
        displayStores(orders) |> ignore
        printf "Input store code: "
        let storeCode = System.Console.ReadLine()
        let totalCostInWeekForStore = orders.Where(fun order -> order.date.week.Equals(week) && order.date.year.Equals(year) && order.store.storeCode.Equals(storeCode)).Sum(fun order -> order.price)
        printf "Total cost for all orders in week %-i of year %-i for store %-s: %-s" week year storeCode (System.String.Format("£{0:#,0.00}", totalCostInWeekForStore))
        System.Console.ReadKey() |> ignore

    let getTotalCostForSupplier(orders:HashSet<Order>) =
        System.Console.Clear()
        displaySuppliers(orders) |> ignore
        printf "Input supplier: "
        let supplier = System.Console.ReadLine()
        let totalCostForSupplier = orders.Where(fun order -> order.supplier.supplierName.Equals(supplier)).Sum(fun order -> order.price)
        printf "Total cost for supplier %-s: %-s" supplier (System.String.Format("£{0:#,0.00}", totalCostForSupplier))
        System.Console.ReadKey() |> ignore

    let getTotalCostForSupplierType(orders:HashSet<Order>) =
        System.Console.Clear()
        displaySupplierTypes(orders) |> ignore
        printf "Input supplier type: "
        let supplierType = System.Console.ReadLine()
        let totalCostForSupplierType = orders.Where(fun order -> order.supplier.supplierType.Equals(supplierType)).Sum(fun order -> order.price)
        printf "Total cost for supplier type %-s: %-s" supplierType (System.String.Format("£{0:#,0.00}", totalCostForSupplierType))
        System.Console.ReadKey() |> ignore

    let getTotalCostInWeekForSupplierType(orders:HashSet<Order>) =
        System.Console.Clear()
        displayDates(orders) |> ignore
        printf "Input week: "
        let week = int32(System.Console.ReadLine())
        printf "Input Year: "
        let year = int32(System.Console.ReadLine())
        displaySupplierTypes(orders) |> ignore
        printf "Input supplier type: "
        let supplierType = System.Console.ReadLine()
        let totalCostInWeekForSupplierType = orders.Where(fun order -> order.date.week.Equals(week) && order.date.year.Equals(year) && order.supplier.supplierType.Equals(supplierType)).Sum(fun order -> order.price)
        printf "Total cost for supplier type %-s in week %-i of year %-i: %-s" supplierType week year (System.String.Format("£{0:#,0.00}", totalCostInWeekForSupplierType))
        System.Console.ReadKey() |> ignore

    let getTotalCostForSupplierTypeForStore(orders:HashSet<Order>) =
        System.Console.Clear()
        displaySupplierTypes(orders) |> ignore
        printf "Input supplier type: "
        let supplierType = System.Console.ReadLine()
        displayStores(orders) |> ignore
        printf "Input store code: "
        let storeCode = System.Console.ReadLine()
        let totalCostForSupplierTypeForStore = orders.Where(fun order -> order.supplier.supplierType.Equals(supplierType) && order.store.storeCode.Equals(storeCode)).Sum(fun order -> order.price)
        printf "Total cost for supplier type %-s for store %-s: %-s" supplierType storeCode (System.String.Format("£{0:#,0.00}", totalCostForSupplierTypeForStore))
        System.Console.ReadKey() |> ignore

    let getTotalCostInWeekForSupplierTypeForStore(orders:HashSet<Order>) =
        System.Console.Clear()
        displayDates(orders) |> ignore
        printf "Input week: "
        let week = int32(System.Console.ReadLine())
        printf "Input Year: "
        let year = int32(System.Console.ReadLine())
        displaySupplierTypes(orders) |> ignore
        printf "Input supplier type: "
        let supplierType = System.Console.ReadLine()
        displayStores(orders) |> ignore
        printf "Input store code: "
        let storeCode = System.Console.ReadLine()
        let totalCostInWeekForSupplierTypeForStore = orders.Where(fun order -> order.date.week.Equals(week) && order.date.year.Equals(year) && order.supplier.supplierType.Equals(supplierType) && order.store.storeCode.Equals(storeCode)).Sum(fun order -> order.price)
        printf "Total cost for supplier type %-s for store %-s in week %-i of year %-i: %-s" supplierType storeCode week year (System.String.Format("£{0:#,0.00}", totalCostInWeekForSupplierTypeForStore))
        System.Console.ReadKey() |> ignore

    let loadData() = 
        System.Console.Clear()
        let monitor = new Object()
        printf "loading..."
        let folderPath = "F:\UNI-LEVEL 5\T-BSE\T-BSE Assignment 1 - J016984C\StoreData"
        let storeCodesFile = "StoreCodes.csv"
        let storeDataFolder = "StoreData"
        let stores = new ConcurrentDictionary<string, Store>()
        let storeCodesFilePath = folderPath + @"\" + storeCodesFile
        let storeCodesData = System.IO.File.ReadAllLines(storeCodesFilePath)
        let mutable storeFilesRead = 0
        for storeData in storeCodesData do
            let mutable storeDataSplit = storeData.Split(",")
            let store = new Store(storeDataSplit.[0], storeDataSplit.[1]) //Store code, Store name
            if not(stores.ContainsKey(store.storeCode)) then
                stores.TryAdd(store.storeCode, store)|>ignore
                storeFilesRead <- storeFilesRead + 1
        let dates = new ConcurrentDictionary<string, Date>()
        let orders = new HashSet<Order>()
        let fileNames = Directory.GetFiles(folderPath + @"\" + storeDataFolder)
        let mutable orderFilesRead = 0
        Parallel.ForEach(fileNames, (fun filePath ->
            let mutable fileNameExt = Path.GetFileName(filePath)
            let mutable fileName = Path.GetFileNameWithoutExtension(filePath)
            let mutable fileNameSplit = fileName.Split('_')
            let store = stores.[fileNameSplit.[0]]
            let date = new Date((Convert.ToInt32(fileNameSplit.[1])), (Convert.ToInt32(fileNameSplit.[2]))) //Week, Year
            if not(dates.ContainsKey(date.ToString())) then
                dates.TryAdd(date.ToString(), date)|>ignore
            let orderData = File.ReadAllLines(folderPath + @"\" + storeDataFolder + @"\" + fileNameExt)
            for entry in orderData do
                let orderSplit = entry.Split(',')
                let order = new Order(store, dates.[date.ToString()], new Supplier(orderSplit.[0], orderSplit.[1]), Convert.ToDouble(orderSplit.[2])) //Store, Date, Supplier(supplierName, supplierType), price
                lock monitor (fun () -> orders.Add(order)) |> ignore
            orderFilesRead <- orderFilesRead + 1
        )) |> ignore
        orders
        
    let displayCalculationsMenu(orders:HashSet<Order>) =
        System.Console.Clear()
        let mutable orders = orders
        let mutable backChosen = false
        while backChosen = false do
            System.Console.Clear()
            printfn "===================="
            printfn "%16s" "CALCULATIONS"
            printfn "===================="
            printfn "1. Total cost of all orders."
            printfn "2. Total cost for a single store."
            printfn "3. Total cost in a week."
            printfn "4. Total cost in a week for a single store."
            printfn "5. Total cost for a supplier."
            printfn "6. Total cost for a supplier type."
            printfn "7. Total cost in a week for a supplier type."
            printfn "8. Total cost for a supplier type for a single store."
            printfn "9. Total cost in a week for a supplier type for a single store."
            printfn "0. Back."
            let input = System.Console.ReadLine()
            if input = "1" then
                getTotalCost(orders) |> ignore
            if input = "2" then
                getTotalCostForStore(orders) |> ignore
            if input = "3" then
                getTotalCostInWeek(orders) |> ignore
            if input = "4" then
                getTotalCostInWeekForStore(orders) |> ignore
            if input = "5" then
                getTotalCostForSupplier(orders) |> ignore
            if input = "6" then
                getTotalCostForSupplierType(orders) |> ignore
            if input = "7" then
                getTotalCostInWeekForSupplierType(orders) |> ignore
            if input = "8" then
                getTotalCostForSupplierTypeForStore(orders) |> ignore
            if input = "9" then
                getTotalCostInWeekForSupplierTypeForStore(orders) |> ignore
            if input = "0" then
                backChosen <- true
            else
                backChosen <- false


    let printMenu() = 
        System.Console.Clear()
        let stopwatch = new Stopwatch()
        let mutable orders = new HashSet<Order>()
        let mutable exitChosen = false;
        while exitChosen = false do
            System.Console.Clear()
            printfn "===================="
            printfn "%12s" "MENU"
            printfn "===================="
            printfn "Options:"
            printfn "1. Load data."
            printfn "2. Display stores."
            printfn "3. Display suppliers."
            printfn "4. Display supplier types."
            printfn "5. Display calculations menu."
            printfn "0. Exit."
            let input = System.Console.ReadLine()
            if input = "1" then
                stopwatch.Start()
                orders <- loadData()
                stopwatch.Stop()
                printfn "Data loaded in %ims" stopwatch.ElapsedMilliseconds
                System.Console.ReadKey() |> ignore
            if (input = "2" && orders.Count > 0) then
                displayStores(orders) |> ignore
            else
                printfn "Data not loaded. Load data first."
            if (input = "3" && orders.Count > 0) then
                displaySuppliers(orders) |> ignore
            else
                printfn "Data not loaded. Load data first."
            if (input = "4" && orders.Count > 0)  then
                displaySupplierTypes(orders) |> ignore
            else
                printfn "Data not loaded. Load data first."
            if input = "5" then
                displayCalculationsMenu(orders) |> ignore
            if input = "0" then
                exitChosen <- true
            else
                exitChosen <- false


    [<EntryPoint>]
    let main argv =
        let result = printMenu()
        0 // return an integer exit code