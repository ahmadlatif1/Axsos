class user:
    def __init__ (self,first_name,last_name,balance):
        self.first_name = first_name
        self.last_name = last_name
        self.balance = balance

    def make_withdrawal(self,amount):
        self.balance -= amount
        

    def display_user_balance(self):
        print(f'{self.first_name}  {self.last_name} - {self.balance} ')

    def transfer_money(self, other, amount):
        self.make_withdrawal(amount)
        other.balance += amount

fwfe = user("Ahmad", "abed", 10000)
swse=user("mohammad","khaseeb",0)
fwfe.display_user_balance()
fwfe.make_withdrawal(200)

fwfe.display_user_balance()
swse.display_user_balance()
fwfe.transfer_money(swse,1800)

fwfe.display_user_balance()
swse.display_user_balance()
