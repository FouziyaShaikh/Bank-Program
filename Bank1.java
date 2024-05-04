import java.util.Scanner;

class Account {
    private String accountHolderName;
    private String address;
    private long addharNumber;
    private String panNumber;
    private int upiPin;
    private double balance;
    private long phoneNumber;

    Account(String cname, String cadd, String cpan, int cupi, double cbal, long cph) {
        this.accountHolderName = cname;
        this.address = cadd;
        this.panNumber = cpan;
        this.upiPin = cupi;
        this.balance = cbal;
        this.phoneNumber = cph;
    }

    public void setAccountHolderName(String updateName) {
        this.accountHolderName = updateName;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAddress(String uadd) {
        this.address = uadd;
    }

    public String getAddress() {
        return address;
    }

    public void setUpi(int uupi) {
        this.upiPin = uupi;
    }

    public void setPhone(long uphone) {
        this.phoneNumber = uphone;
    }

    public long getPhone() {
        return phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance =balance+ amount;
        System.out.println("Amount deposited successfully. Updated balance: " + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Amount withdrawn successfully. Updated balance: " + balance);
        } 
        else 
        {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }
}

public class Bank1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account obj = null;
        boolean exit = false;
        double cbal = 0; // Declare cbal outside the switch statement

        while (!exit) {
            System.out.println("1. Create Account");
            System.out.println("2. Existing User");
            System.out.println("3. Exit");
            System.out.println("Choose option");
            int num = sc.nextInt();

            switch (num) {
                case 1: {
                    System.out.println("Enter Name:");
                    String cname = sc.next();
                    System.out.println("Enter Address");
                    String cadd = sc.next();
                    System.out.println("Enter Pan Number");
                    String cpan = sc.next();
                    System.out.println("Enter Upi Pin");
                    int cupi = sc.nextInt();
                    System.out.println("Enter Balance");
                    cbal = sc.nextDouble(); // udpate currentbalance
                    System.out.println("Enter Phone Number");
                    long cph = sc.nextLong();
                    System.out.println("Account Created Successfully");

                    obj = new Account(cname, cadd, cpan, cupi, cbal, cph);
                }
                break;

                case 2: {
                    if (obj != null) {
                        System.out.println("1. Check Balance");
                        System.out.println("2. Deposit Amount");
                        System.out.println("3. Withdrawal Amount");
                        System.out.println("4. Update Account");
                        System.out.println("5. Logout");
                        System.out.println("Choose option");
                        int num1 = sc.nextInt();

                        switch (num1) {
                            case 1: {
                                System.out.println("Balance is: " + obj.getBalance());
                            }
                            break;

                            case 2: {
                                System.out.println("Enter Deposit amount:");
                                double deposit = sc.nextDouble();
                                obj.deposit(deposit);
                            }
                            break;

                            case 3: {
                                System.out.println("Enter Withdrawal amount:");
                                double withdrawal = sc.nextDouble();
                                obj.withdraw(withdrawal);
                            }
                            break;

                            case 4: {
                                System.out.println("1. Account Holder Name");
                                System.out.println("2. Address");
                                System.out.println("3. UPI Pin");
                                System.out.println("4. Phone Number");
                                System.out.println("Choose option");
                                int num2 = sc.nextInt();

                                switch (num2) {
                                    case 1: {
                                        System.out.println("Enter New name:");
                                        String uname = sc.next();
                                        obj.setAccountHolderName(uname);
                                    }
                                    break;

                                    case 2: {
                                        System.out.println("Enter New Address:");
                                        String uadd = sc.next();
                                        obj.setAddress(uadd);
                                    }
                                    break;

                                    case 3: {
                                        System.out.println("Enter New UPI:");
                                        int uupi = sc.nextInt();
                                        obj.setUpi(uupi);
                                    }
                                    break;

                                    case 4: {
                                        System.out.println("Enter New Phone Number:");
                                        long uphone = sc.nextLong();
                                        obj.setPhone(uphone);
                                    }
                                    break;

                                    default:
                                        System.out.println("Error ! Not a Correct Option");
                                }
                            }
                            break;

                            case 5: 
                            {
                                obj = null;
                                System.out.println("Logged out successfully.");
                                System.exit(0);
                            }
                            break;

                            default:
                                System.out.println("Error enter correct option");
                        }
                    } 
                    else 
                    {
                        System.out.println("Create account first");
                    }
                }
                break;

                case 3: {
                    exit = true;
                    System.out.println("Exiting program. Goodbye!");
                }
                break;

                default:
                    System.out.println("Error ! Enter Correct Option");
            }
        }

        
    }
}