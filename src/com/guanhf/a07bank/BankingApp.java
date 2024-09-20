package com.guanhf.a07bank;


import java.util.Scanner;

public class BankingApp {

    public static void main(String[] args) {
        run();
    }

    // 主程序运行方法，显示主菜单并处理用户输入
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        Customer customer = null; // customer 是实例变量，不是静态的
        boolean exit = false;

        System.out.println("欢迎使用银行系统");

        while (!exit) {
            System.out.println("1. 开户 create");
            System.out.println("2. 存款 save");
            System.out.println("3. 取款 withdraw");
            System.out.println("4. 消费 consume");
            System.out.println("5. 还款 repay");
            System.out.println("6. 银行结算 settle");
            System.out.println("7. 查询余额 balance");
            System.out.println("8. 退出 exit");
            System.out.print("请选择(1-8): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    customer = createAccount();
                    break;
                case 2:
                    save(customer);
                    break;
                case 3:
                    withdraw(customer);
                    break;
                case 4:
                    consume(customer);
                    break;
                case 5:
                    repay(customer);
                    break;
                case 6:
                    settle(customer);
                    break;
                case 7:
                    checkBalance(customer);
                    break;
                case 8:
                    exit = true;
                    System.out.println("已成功退出银行系统");
                    break;
                default:
                    System.out.println("无效选择，请重新选择！");
            }
        }

        scanner.close();
    }

    // 1. 开户功能：选择账户类型并创建新账户
    public static Customer createAccount() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请选择开卡类型");
        System.out.println("1. 信用卡 checkingAccount");
        System.out.println("2. 存储卡 savingAccount");
        System.out.println("3. 返回主菜单 exit");
        System.out.print("请选择（1-3）: ");

        int choice = scanner.nextInt();
        Customer customer = null;

        switch (choice) {
            case 1:
                System.out.print("请输入 SSN: ");
                String ssn = scanner.next();
                System.out.print("请输入姓名: ");
                String name = scanner.next();
                System.out.print("请输入卡号: ");
                String accountNumber = scanner.next();
                System.out.print("请输入服务费: ");
                double serviceCharge = scanner.nextDouble();

                CheckingAccount checkingAccount = new CheckingAccount(accountNumber, 0, serviceCharge);
                customer = new Customer(ssn, name, checkingAccount, null);
                System.out.println("信用卡账户创建成功！");
                break;

            case 2:
                System.out.print("请输入 SSN: ");
                ssn = scanner.next();
                System.out.print("请输入姓名: ");
                name = scanner.next();
                System.out.print("请输入卡号: ");
                accountNumber = scanner.next();
                System.out.print("请输入利率: ");
                double interestRate = scanner.nextDouble();

                SavingAccount savingAccount = new SavingAccount(accountNumber, 0, interestRate);
                customer = new Customer(ssn, name, null, savingAccount);
                System.out.println("存储卡账户创建成功！");
                break;

            case 3:
                System.out.println("返回主菜单");
                break;

            default:
                System.out.println("无效选择，请重新选择！");
        }

        return customer;
    }

    // 2. 存款功能
    public static void save(Customer customer) {
        if (customer == null) {
            System.out.println("请先创建账户！");
            return;
        }
        Scanner scanner = new Scanner(System.in);

        System.out.println("请选择存款账户类型");
        System.out.println("1. 信用卡 checkingAccount");
        System.out.println("2. 存储卡 savingAccount");
        System.out.print("请选择（1-2）: ");
        int choice = scanner.nextInt();

        System.out.print("请输入存款金额: ");
        double amount = scanner.nextDouble();

        switch (choice) {
            case 1:
                if (customer.getCheckingAccount() != null) {
                    customer.getCheckingAccount().setBalance(customer.getCheckingAccount().getBalance() + amount);
                    System.out.println("存款成功！当前信用卡余额: " + customer.getCheckingAccount().getBalance());
                } else {
                    System.out.println("信用卡账户不存在！");
                }
                break;
            case 2:
                if (customer.getSavingAccount() != null) {
                    customer.getSavingAccount().setBalance(customer.getSavingAccount().getBalance() + amount);
                    System.out.println("存款成功！当前存储卡余额: " + customer.getSavingAccount().getBalance());
                } else {
                    System.out.println("存储卡账户不存在！");
                }
                break;
            default:
                System.out.println("无效选择，请重新选择！");
        }
    }

    // 3. 取款功能
    public static void withdraw(Customer customer) {
        if (customer == null) {
            System.out.println("请先创建账户！");
            return;
        }
        Scanner scanner = new Scanner(System.in);

        System.out.println("请选择取款账户类型");
        System.out.println("1. 信用卡 checkingAccount");
        System.out.println("2. 存储卡 savingAccount");
        System.out.print("请选择（1-2）: ");
        int choice = scanner.nextInt();

        System.out.print("请输入取款金额: ");
        double amount = scanner.nextDouble();

        switch (choice) {
            case 1:
                if (customer.getCheckingAccount() != null) {
                    if (customer.getCheckingAccount().getBalance() >= amount) {
                        customer.getCheckingAccount().setBalance(customer.getCheckingAccount().getBalance() - amount);
                        System.out.println("取款成功！当前信用卡余额: " + customer.getCheckingAccount().getBalance());
                    } else {
                        System.out.println("信用卡余额不足！");
                    }
                } else {
                    System.out.println("信用卡账户不存在！");
                }
                break;
            case 2:
                if (customer.getSavingAccount() != null) {
                    if (customer.getSavingAccount().getBalance() >= amount) {
                        customer.getSavingAccount().setBalance(customer.getSavingAccount().getBalance() - amount);
                        System.out.println("取款成功！当前存储卡余额: " + customer.getSavingAccount().getBalance());
                    } else {
                        System.out.println("存储卡余额不足！");
                    }
                } else {
                    System.out.println("存储卡账户不存在！");
                }
                break;
            default:
                System.out.println("无效选择，请重新选择！");
        }
    }

    // 4. 消费功能
    public static void consume(Customer customer) {
        if (customer == null || customer.getCheckingAccount() == null) {
            System.out.println("请先创建信用卡账户！");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("请选择消费账户类型");
        System.out.println("1. 信用卡 checkingAccount");
        System.out.println("2. 存储卡 savingAccount");
        System.out.print("请选择（1-2）: ");
        int choice = scanner.nextInt();

        System.out.print("请输入消费金额: ");
        double amount = scanner.nextDouble();

        switch (choice) {
            case 1:
                if (customer.getCheckingAccount().getBalance() >= amount) {
                    customer.getCheckingAccount().setBalance(customer.getCheckingAccount().getBalance() - amount);
                    System.out.println("消费成功！当前信用卡余额: " + customer.getCheckingAccount().getBalance());
                } else {
                    System.out.println("信用卡余额不足！");
                }
                break;
            case 2:
                if (customer.getSavingAccount().getBalance() >= amount) {
                    customer.getSavingAccount().setBalance(customer.getSavingAccount().getBalance() - amount);
                    System.out.println("消费成功！当前存储卡余额: " + customer.getSavingAccount().getBalance());
                } else {
                    System.out.println("存储卡余额不足！");
                }
                break;
            default:
                System.out.println("无效选择，请重新选择！");
        }
    }

    // 5. 还款功能
    public static void repay(Customer customer) {
        // 针对信用卡的还款功能
        if (customer == null || customer.getCheckingAccount() == null) {
            System.out.println("请先创建信用卡账户！");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入还款金额: ");
        double amount = scanner.nextDouble();

        customer.getCheckingAccount().setBalance(customer.getCheckingAccount().getBalance() + amount);
        System.out.println("还款成功！当前余额: " + customer.getCheckingAccount().getBalance());

    }

    // 6. 银行结算功能
    public static void settle(Customer customer) {
        if (customer == null) {
            System.out.println("请先创建账户！");
            return;
        }

        if (customer.getCheckingAccount() != null) {
            customer.getCheckingAccount().settleAccount();
            System.out.println("信用卡服务费结算完成！");
        } else if (customer.getSavingAccount() != null) {
            customer.getSavingAccount().accrueInterest();
            System.out.println("存储卡利息结算完成！");
        }
    }

    // 7. 查询余额功能
    public static void checkBalance(Customer customer) {
        if (customer == null) {
            System.out.println("请先创建账户！");
            return;
        }

        if (customer.getCheckingAccount() != null) {
            System.out.println("信用卡余额: " + customer.getCheckingAccount().getBalance());
        } else if (customer.getSavingAccount() != null) {
            System.out.println("存储卡余额: " + customer.getSavingAccount().getBalance());
        }
    }
}
