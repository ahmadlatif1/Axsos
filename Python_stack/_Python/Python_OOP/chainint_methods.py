class user:
    def __init__ (self,first_name,last_name,balance):
        self.first_name = first_name
        self.last_name = last_name
        self.balance = balance

    def make_withdrawal(self,amount):
        self.balance -= amount
        return self
        

    def display_user_balance(self):
        print(f'{self.first_name}  {self.last_name} - {self.balance} ')
        return self

    def make_deposit(self,amount):
        self.balance +=amount
        return self


    def transfer_money(self, other, amount):
        self.make_withdrawal(amount)
        other.balance += amount
        return self

user1 = user("Ahmad", "abed", 10000)
user2=user("mohammad","khaseeb",0)

user1.display_user_balance().make_withdrawal(200).display_user_balance()