class BankAccount {
    int balance = 1000;

    void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
        }
    }
}
/*
  Now suppose two threads try to withdraw ₹700 at the same time:

Both read balance as ₹1000.

Both think there’s enough money.

Both subtract ₹700 → final balance becomes ₹300 instead of ₹100 or -₹400.

👉 This is a race condition because multiple threads are reading/writing the same balance without synchronization.
 */