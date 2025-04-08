class BankAccount:
    def __init__(self, int_rate=0, balance=0):
        self.balance=balance
        self.int_rate=int_rate
        

    def deposit(self, amount=0):
        self.balance+=amount
        return self
    
    def get_balance(self):
        return self.balance
    
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
    def __init__(self,first_name="first",last_name="last",account=[BankAccount()]):
        self.first_name = first_name
        self.last_name = last_name
        self.account=account
    
    
    def make_withdrawal(self,amount,account_num=0):
        self.account[account_num].withdraw(amount)
        return self
        
    def get_balance(self,account_num=0):
        return self.account[account_num].balance

    def display_user_balance(self,account_num=0):
        print(f'{self.first_name}  {self.last_name} - {self.account[account_num].balance} ')
        return self

    def make_deposit(self,amount,account_num=0):
        self.account[account_num].deposit(amount)
        return self


    def transfer_money(self, other, amount,account_num=0):
        self.make_withdrawal(amount)
        other.balance += amount
        return self

user1 = user("Ahmad", "abed")

user1.display_user_balance().make_deposit(200).display_user_balance()


firstaccount=BankAccount(0.05,20000)
secondaccount=BankAccount(0.05,3333)


user2=user("mohammad","khaseeb",[firstaccount,secondaccount])

user2.display_user_balance().display_user_balance(1)

user2.transfer_money(user2.account[1],10000).display_user_balance().display_user_balance(1)