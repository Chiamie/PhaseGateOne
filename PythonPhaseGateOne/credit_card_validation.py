
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
	
def get_list_form_of(card_number):
	if type(card_number) != str:
		raise TypeError("card_number must be a string")
	if card_number == "":
		raise ValueError("card_number cannot be empty")
	for item in card_number:
		if not item.isdigit():
			raise ValueError("card_number must be all numeric strings")

	card_number_as_list = []
	card_number_as_string_in_list = list(card_number)
	for item in card_number_as_string_in_list:
		card_number_as_list.append(int(item))
	return card_number_as_list		

def double_digits_at_even_index_in(card_number_as_list):
	if type(card_number_as_list) != list:
		raise TypeError("card_number_as_list must be a List")
	if card_number_as_list == "":
		raise ValueError("card_number_as_list cannot be empty")
	if all(type(item) != int for item in card_number_as_list):
			raise ValueError("list_of_numbers must all be integers")
	if any(type(item) != int for item in card_number_as_list):
			raise ValueError("list_of_numbers must all be integers")
	for item in card_number_as_list:
		if item < 0:
			raise ValueError("item must all be integers")

	sum = 0
	for number in range((len(card_number_as_list) - 1), -1, -1):
		product = 1;
		if number % 2 == 0:
			if card_number_as_list[number] % 10 != 0:
				product = card_number_as_list[number] * 2
				sum += (product % 10) + (product // 10)
			else:
				sum += card_number_as_list[number] * 2
	return sum


def get_sum_of_digit_at_odd_index_of(card_number_as_list):
	if type(card_number_as_list) != list:
		raise TypeError("card_number_as_list must be a List")
	if card_number_as_list == "":
		raise ValueError("card_number_as_list cannot be empty")
	if all(type(item) != int for item in card_number_as_list):
			raise ValueError("list_of_numbers must all be integers")
	if any(type(item) != int for item in card_number_as_list):
			raise ValueError("list_of_numbers must all be integers")
	for item in card_number_as_list:
		if item < 0:
			raise ValueError("item must all be integers")

	sum = 0;
	for number in range((len(card_number_as_list) - 1), -1, -1):
		if number % 2 != 0:
			sum += card_number_as_list[number]
	return sum

def check_divisibility_by_ten(total):
	if type(total) != int:
		raise TypeError("total must be an Integer")
	if total == 0:
		raise ValueError("total cannot be empty")
	if total < 0:
		raise ValueError("total cannot be negative")
	if total % 10 == 0:
		return "Valid"
	else:
		return "Invalid"









