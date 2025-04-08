class BankAccount:
    def __init__(self, int_rate=0, balance=0):
        self.balance=balance
        self.int_rate=int_rate
        

    def deposit(self, amount=0):
        self.balance+=amount
        return self
        
    def withdraw(self, amount=0):
        if self.balance-amount<0:
            print("Insufficient funds: charging a $5 fee")
            return self
        self.balance-=amount
        return self
    
    def display_account_info(self):
        print(f"{self.balance}")
        return self
    
    def yield_interest(self):
        self.balance+=self.balance*self.int_rate
        return self
class user:
    def __init__(self,first_name="first",last_name="last",account=BankAccount()):
        self.first_name = first_name
        self.last_name = last_name
        self.account=account
    
    
firstaccount=BankAccount(0.05)
secondaccount=BankAccount(0.05)

firstaccount.deposit(200).deposit(100).deposit(3000).withdraw(1000).yield_interest().display_account_info()


firstaccount.deposit(200).deposit(10000).withdraw(100).withdraw(100).withdraw(100).withdraw(1000).yield_interest().display_account_info()
