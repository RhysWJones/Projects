﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataParallelismProj.DTO
{
    class Date
    {
        private int _week;
        public int Week
        {
            get
            {
                return _week;
            }
            set
            {
                if (!(value < 0 || value > 52))
                {
                    _week = value;

                }
            }
        }

        private int _year;
        public int Year
        {
            get
            {
                return _year;
            }

            set
            {
                if(!(value < 1970))
                {
                    _year = value;
                }
            }
        }
        override
        public String ToString()
        {
            return "Week: " + Week + " Year: " + Year;
        }
    }
}
