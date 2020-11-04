package com.sda.PostOffice;
import java.util.EnumSet;
import java.util.Scanner;

public class PostOfficeApp {
    public static void main(String[] args) {
        Package package1 = new Package();
        String status = package1.getStatus();


        while(!String.valueOf(EnumSet.of(PackageStatus.DELIVERED, PackageStatus.LOST, PackageStatus.RETURNED)).contains(status)) {
            System.out.println(package1);
            PackageStatus.valueOf(status).getNextStatuses();
            //get list of statuses possible for current status
            Scanner input = new Scanner(System.in);
            System.out.println("Enter next status:");
            String newStatus = input.nextLine();
            try {
                package1.changeStatus(PackageStatus.valueOf(status), PackageStatus.valueOf(newStatus));
            } catch (IllegalArgumentException exception) {
                System.out.println("Status is not correct. Please try again");
            }
        }
        System.out.println(package1);
    }
}
