
def check_type_of_card(card_number):
	if type(card_number) != str:
		raise TypeError("card_number must be a string")
	if card_number == "":
		raise ValueError("card_number cannot be empty")
	for item in card_number:
		if not item.isdigit():
			raise ValueError("card_number must be all numeric strings")

	if card_number[0] == '4':
		return "Visa Card"
	elif card_number[0] == '5':
		return "MasterCard"
	elif card_number[0] == '6':
		return "Discover cards"
	elif card_number[0] == '3' and card_number[1] == '7':
		return "American Express Card"
	else:
		return "Invalid card"

def check_card_number_length(card_number):
	if type(card_number) != str:
		raise TypeError("card_number must be a string")
	if card_number == "":
		raise ValueError("card_number cannot be empty")
	for item in card_number:
		if not item.isdigit():
			raise ValueError("card_number must be all numeric strings")

	if len(card_number) >= 13 and len(card_number) <= 16:
		card_length = str(len(card_number))
		return card_length
	else:
		return "Invalid Card Number"
	








