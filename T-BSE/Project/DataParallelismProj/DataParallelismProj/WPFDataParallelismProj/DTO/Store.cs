﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WPFDataParallelismProj.DTO
{
    class Store
    {
        public String StoreCode { get; set; }
        public String StoreName { get; set; }

        public Store()
            : this("", "")
        {

        }
        
        public Store(String storeCode, String storeName)
        {
            this.StoreCode = storeCode;
            this.StoreName = storeName;
        }

        override
       public String ToString()
        {
            return StoreCode + ", " + StoreName;
        }
    }
}