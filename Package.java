package com.sda.PostOffice;
import java.util.EnumSet;

import java.util.UUID;

import static java.lang.String.valueOf;

public class Package {
    String name;
    private UUID uuid; //unique universal identificator
    private PackageStatus packageStatus;

    public Package() {
        this.uuid = UUID.randomUUID();
        this.packageStatus = PackageStatus.SENT;
    }

    //wygląda ze problem jest w tym miejscu ale nie moge zrozumiec co jest nie tak
    public void changeStatus(PackageStatus oldPackageStatus, PackageStatus newPackageStatus){
        EnumSet possibleStatuses = oldPackageStatus.getNextStatuses();
        if (String.valueOf(possibleStatuses).contains(valueOf(newPackageStatus))) //if given next status is in the list of current statuses - change the status
            this.packageStatus = newPackageStatus;//ma zmienic status jesli nowy jest w liscie możliwych statusow

    }

    public String getStatus (){
        return String.valueOf(packageStatus);
    }



    @Override
    public String toString() {
        return "Package{" +
                "name= '" + name + '\'' +
                ", uuid= " + uuid +
                ", package status= " + packageStatus.getDescription() +
                ", status code= " + packageStatus.getCode() +
                '}';
    }

}


