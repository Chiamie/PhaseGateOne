import unittest
import inspect
from credit_card_validation import check_type_of_card
from credit_card_validation import check_card_number_length
from credit_card_validation import get_list_form_of
from credit_card_validation import double_digits_at_even_index_in
from credit_card_validation import get_sum_of_digit_at_odd_index_of







class TestCheckTypeOfCardFunction(unittest.TestCase):
	def test_that_the_check_type_of_card_function_accepts_1_argument(self):
		function_signature = inspect.signature(check_type_of_card)
		dic_parameter = function_signature.parameters
		self.assertEqual(len(dic_parameter), 1)
	def test_that_the_check_type_of_card_function_raises_validation_when_argument_is_a_float(self):
		self.assertRaises(TypeError, check_type_of_card, 32.8)
	def test_that_the_check_type_of_card_function_raises_validation_when_argument_is_an_integer(self):
		self.assertRaises(TypeError, check_type_of_card, 32)
	def test_that_the_check_type_of_card_function_raises_validation_when_argument_is_a_non_numeric_string(self):
		self.assertRaises(ValueError, check_type_of_card, "mummy")
	def test_that_the_check_type_of_card_function_raises_validation_when_argument_is_empty(self):
		self.assertRaises(ValueError, check_type_of_card, "")
	def test_that_the_check_type_of_card_function_returns_correct_result(self):
		result = check_type_of_card("5399831619690404")
		self.assertEqual(result, 'MasterCard')

class TestCheckCardNumberLengthFunction(unittest.TestCase):
	def test_that_the_check_type_of_card_function_accepts_1_argument(self):
		function_signature = inspect.signature(check_card_number_length)
		dic_parameter = function_signature.parameters
		self.assertEqual(len(dic_parameter), 1)
	def test_that_the_check_card_number_length_function_raises_validation_when_argument_is_a_float(self):
		self.assertRaises(TypeError, check_card_number_length, 32.8)
	def test_that_the_check_card_number_length_function_raises_validation_when_argument_is_an_integer(self):
		self.assertRaises(TypeError, check_card_number_length, 32)
	def test_that_the_check_card_number_length_function_raises_validation_when_argument_is_a_non_numeric_string(self):
		self.assertRaises(ValueError, check_card_number_length, "mummy")
	def test_that_the_check_card_number_length_function_raises_validation_when_argument_is_empty(self):
		self.assertRaises(ValueError, check_card_number_length, "")
	def test_that_the_check_card_number_length_function_returns_correct_result(self):
		result = check_card_number_length("5399831619690404")
		self.assertEqual(result, '16')

class TestGetListForm0fFunction(unittest.TestCase):
	def test_that_the_get_list_form_of_function_accepts_1_argument(self):
		function_signature = inspect.signature(get_list_form_of)
		dic_parameter = function_signature.parameters
		self.assertEqual(len(dic_parameter), 1)
	def test_that_the_get_list_form_of_function_raises_validation_when_argument_is_a_float(self):
		self.assertRaises(TypeError, get_list_form_of, 32.8)
	def test_that_the_get_list_form_of_function_raises_validation_when_argument_is_an_integer(self):
		self.assertRaises(TypeError, get_list_form_of, 32)
	def test_that_the_get_list_form_of_function_raises_validation_when_argument_is_a_non_numeric_string(self):
		self.assertRaises(ValueError, get_list_form_of, "mummy")
	def test_that_the_get_list_form_of_function_raises_validation_when_argument_is_empty(self):
		self.assertRaises(ValueError, get_list_form_of, "")
	def test_that_the_get_list_form_of_function_returns_correct_result(self):
		result = get_list_form_of("5399831619690404")
		self.assertEqual(result, [5, 3, 9, 9, 8, 3, 1, 6, 1, 9, 6, 9, 0, 4, 0, 4])

class TestDoubleDigitsAtEvenIndexInFunction(unittest.TestCase):
	def test_that_the_double_digits_at_even_index_in_function_accepts_1_argument(self):
		list_of_numbers = [1, 5, 3, 7, 8, 6]
		result = double_digits_at_even_index_in(list_of_numbers)
		self.assertTrue(list_of_numbers, list)
	def test_that_the_double_digits_at_even_index_in_function_raises_validation_when_argument_is_a_float(self):
		self.assertRaises(TypeError, double_digits_at_even_index_in, 32.8)
	def test_that_the_double_digits_at_even_index_in_function_raises_validation_when_argument_is_a_list(self):
		self.assertRaises(TypeError, double_digits_at_even_index_in, "not a list")
	def test_that_the_double_digits_at_even_index_in_function_raises_validation_when_argument_is_a_number(self):
		self.assertRaises(TypeError, double_digits_at_even_index_in, 98)
	def test_that_the_double_digits_at_even_index_in_function_raises_validation_if_list_has_negative_number(self):
		list_of_integers = [1, 5, 3, -7, 5, 8, 6]
		self.assertRaises(ValueError, double_digits_at_even_index_in, list_of_integers)
	def test_that_the_double_digits_at_even_index_in_function_raises_validation_if_list_has_float_numbers(self):
		list_of_integers = [1.5, 5.4, 3.2, -7.7, 5.3, 8.5, 6.8]
		self.assertRaises(ValueError, double_digits_at_even_index_in, list_of_integers)
	def test_that_the_double_digits_at_even_index_in_function_raises_validation_if_list_has_numeric_and_non_numeric_items(self):
		list_of_integers = ['1','awele', '3', -7, 'plate', 8, '6']
		self.assertRaises(ValueError, double_digits_at_even_index_in, list_of_integers)
	def test_that_the_double_digits_at_even_index_in_function_raises_validation_if_input_is_not_a_list_of_numbers(self):
		list_of_integers = ['awele', 'nutrient', 'plate']
		self.assertRaises(ValueError, double_digits_at_even_index_in, list_of_integers)
	def test_that_the_double_digits_at_even_index_in_function_raises_validation_when_argument_is_empty(self):
		list_of_integers = []
		self.assertRaises(ValueError, double_digits_at_even_index_in, list_of_integers)
	def test_that_the_double_digits_at_even_index_in_function_returns_correct_result(self):
		result = double_digits_at_even_index_in([5, 3, 9, 9, 8, 3, 1, 6, 1, 9, 6, 9, 0, 4, 0, 4])
		self.assertEqual(result, 24)
	
class TestGetSumOfDigitAtOddIndexOfFunction(unittest.TestCase):
	def test_that_the_get_sum_of_digit_at_odd_index_of_function_accepts_1_argument(self):
		list_of_numbers = [1, 5, 3, 7, 8, 6]
		result = get_sum_of_digit_at_odd_index_of(list_of_numbers)
		self.assertTrue(list_of_numbers, list)
	def test_that_the_get_sum_of_digit_at_odd_index_of_function_raises_validation_when_argument_is_a_float(self):
		self.assertRaises(TypeError, get_sum_of_digit_at_odd_index_of, 32.8)
	def test_that_the_get_sum_of_digit_at_odd_index_of_function_raises_validation_when_argument_is_a_list(self):
		self.assertRaises(TypeError, get_sum_of_digit_at_odd_index_of, "not a list")
	def test_that_the_get_sum_of_digit_at_odd_index_of_function_raises_validation_when_argument_is_a_number(self):
		self.assertRaises(TypeError, get_sum_of_digit_at_odd_index_of, 98)
	def test_that_the_get_sum_of_digit_at_odd_index_of_function_raises_validation_if_list_has_negative_number(self):
		list_of_integers = [1, 5, 3, -7, 5, 8, 6]
		self.assertRaises(ValueError, get_sum_of_digit_at_odd_index_of, list_of_integers)
	def test_that_the_get_sum_of_digit_at_odd_index_of_function_raises_validation_if_list_has_float_numbers(self):
		list_of_integers = [1.5, 5.4, 3.2, -7.7, 5.3, 8.5, 6.8]
		self.assertRaises(ValueError, get_sum_of_digit_at_odd_index_of, list_of_integers)
	def test_that_the_get_sum_of_digit_at_odd_index_of_function_raises_validation_if_list_has_numeric_and_non_numeric_items(self):
		list_of_integers = ['1','awele', '3', -7, 'plate', 8, '6']
		self.assertRaises(ValueError, get_sum_of_digit_at_odd_index_of, list_of_integers)
	def test_that_the_get_sum_of_digit_at_odd_index_of_function_raises_validation_if_input_is_not_a_list_of_numbers(self):
		list_of_integers = ['awele', 'nutrient', 'plate']
		self.assertRaises(ValueError, get_sum_of_digit_at_odd_index_of, list_of_integers)
	def test_that_the_get_sum_of_digit_at_odd_index_of_function_raises_validation_when_argument_is_empty(self):
		list_of_integers = []
		self.assertRaises(ValueError, get_sum_of_digit_at_odd_index_of, list_of_integers)
	def test_that_the_get_sum_of_digit_at_odd_index_of_function_returns_correct_result(self):
		result = get_sum_of_digit_at_odd_index_of([5, 3, 9, 9, 8, 3, 1, 6, 1, 9, 6, 9, 0, 4, 0, 4])
		self.assertEqual(result, 47)
	
	
	
	
	
	
	
	