module Date

type Date(week:int, year:int) =
    member this.week = week
    member this.year = year

    member this.ToString() = sprintf "Week: %-i Year: %-i" this.week this.year