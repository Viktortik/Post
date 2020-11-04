package com.sda.PostOffice;

import java.util.EnumSet;
import java.util.Set;

public enum PackageStatus {
    SENT ("SNT", "Sent") //- paczka została nadana, ale jeszcze nie wyjechała w podróż.
            {@Override
            public EnumSet getNextStatuses(){
                EnumSet possiblePackageStatus = EnumSet.of (TRAVELLING, LOST);
                System.out.println("Possible next statuses are: " + possiblePackageStatus);
                return possiblePackageStatus;
            }
            },
    TRAVELLING ("TRL", "Travelling") //- paczka jest w trakcie podróży między oddziałami.
            {@Override
            public EnumSet getNextStatuses(){
                EnumSet possiblePackageStatus = EnumSet.of (COURIER, LOST);
                System.out.println("Possible next statuses are: " + possiblePackageStatus);
                return possiblePackageStatus;
            }
            },
    COURIER ("CRR", "Courier") // - paczka jest już u kuriera w doręczeniu.
            {@Override
            public EnumSet getNextStatuses(){
                EnumSet possiblePackageStatus = EnumSet.of (DELIVERED, RETURNED, LOST);
                System.out.println("Possible next statuses are: " + possiblePackageStatus);
                return possiblePackageStatus;
            }
            },
    DELIVERED("DLR", "Delivered") //  - paczka została dostarczona.
            { //status ostateczny
                @Override
                public EnumSet getNextStatuses() {
                    try {
                        Set possiblePackageStatus = EnumSet.of(null);
                        System.out.println(possiblePackageStatus);
                    } catch (NullPointerException exception) {
                        System.out.println("Your package is ");
                    }
                    return null;
                }

            },
    LOST ("LST", "Lost") // - paczka została zagubiona.
            { //status ostateczny
                @Override
                public EnumSet getNextStatuses () {
                    try {
                        Set possiblePackageStatus = EnumSet.of(null);
                        System.out.println(possiblePackageStatus);
                    } catch (NullPointerException exception) {
                        System.out.println("Your package is ");

                    }
                    return null;
                }
            },
    RETURNED ("RTN", "Returned") //- paczka została zwrócona do nadawcy.
            { //status ostateczny
                @Override
                public EnumSet getNextStatuses() {
                    try{
                        Set possiblePackageStatus = EnumSet.of(null);
                        //System.out.println(possiblePackageStatus);
                    } catch (NullPointerException exception){
                        System.out.println("Your package is ");
                    }
                    return null;
                }
            };


    private String code;
    private String description;

    PackageStatus(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode(){
        return code;
    }

    public String getDescription(){
        return description;
    }

    public abstract EnumSet getNextStatuses();
}

