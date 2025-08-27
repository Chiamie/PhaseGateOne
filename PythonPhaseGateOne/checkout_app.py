from datetime import datetime

def get_product_details(item_name, item_quantity, item_price, item_total):
	product_details = {}
	product_details['ITEM'] = item_name;
	product_details['QTY'] = item_quantity;
	product_details['PRICE'] = item_price;
	product_details['TOTAL'] = item_total;
	return product_details


def get_sub_total(user_cart):
	sum = 0;
	for number in range(0, len(user_cart)):
		for detail in user_cart[number]:
			if detail == "TOTAL":
				sum += user_cart[number][detail]
	return sum

	
def get_discount_of(sub_total, discount):
	discount_amount = sub_total * (discount / 100)
	return discount_amount


def get_vat_of(sub_total):
	vat_amount = sub_total * (17.50 / 100)
	return vat_amount



def get_bill_total(sub_total, discount_amount, vat_amount):
	return (sub_total - discount_amount) + vat_amount


def get_balance(amount_received, bill_total):
	return amount_received -  bill_total





user_cart = []



user_name = input("What is the customer's Name? ")

item_name = input("What did the customer buy? ")
item_quantity = int(input("How many pieces? "))
item_price = int(input("How much per unit? "))
item_total = item_price * item_quantity


user_cart.append(get_product_details(item_name, item_quantity, item_price, item_total))
add_more_items = input("Add more Items? ")
while add_more_items.lower() == "yes":
	item_name = input("What did the customer buy? ")
	item_quantity = int(input("How many pieces? "))
	item_price = int(input("How much per unit? "))
	item_total = item_price * item_quantity
	user_cart.append(get_product_details(item_name, item_quantity, item_price, item_total))
	add_more_items = input("Add more Items? ")


cashier_name = input("What is your name? ")
discount = int(input("How much discount will he get? "))
sub_total = get_sub_total(user_cart)
discount_amount = get_discount_of(sub_total, discount)
vat_amount = get_vat_of(sub_total)
bill_total = get_bill_total(sub_total, discount_amount, vat_amount)

name_of_store = """SEMICOLON STORES
				MAIN BRANCH
			"""
store_address = "312, HERBERT MACAULAY WAY, SABO YABA, LAGOS"
contact = "03293828343"
current_datetime = datetime.now()


print(name_of_store)
print("LOCATION: " + store_address)
print("TEL: " + contact)
print(f'Date {current_datetime}')
print("Cashier: " + cashier_name)

print("Customer Name: " + user_name)


 
print("--" * 10)
columns = user_cart[0].keys()
print("\t" * 5 + "\t".join(columns))
for row in user_cart:
	print("\t".join(str(value) for value in row.values()))

print("\t" * 4 + "Sub Total", sub_total)
print("\t" * 4 + "Discount", discount_amount)
print("\t" * 4 + "VAT @ 17.50%", vat_amount)
print("\t" * 4 + "Bill Total", bill_total)

print("THIS IS NOT A RECEIPT KINDLY PAY", bill_total)




amount_received = int(input("How much did the customer give to you? "))
balance = get_balance(amount_received, bill_total)

print("--" * 10)
columns = user_cart[0].keys()
print("\t" * 5 + "\t".join(columns))
for row in user_cart:
	print("\t".join(str(value) for value in row.values()))

print("\t" * 4 + "Sub Total: ", sub_total)
print("\t" * 4 + "Discount: ", discount_amount)
print("\t" * 4 + "VAT @ 17.50%: ", vat_amount)
print("\t" * 4 + "Bill Total: ", bill_total)
print("\t" * 4 + "Amount Paid: ", amount_received)
print("\t" * 4 + "Balance: ", balance)

print("THANK YOU FOR YOUR PATRONAGE")
















































