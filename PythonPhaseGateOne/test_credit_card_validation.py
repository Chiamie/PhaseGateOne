import unittest
import inspect
from credit_card_validation import check_type_of_card
from credit_card_validation import check_card_number_length



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
		self.assertRaises(TypeError, check_type_of_card, "mummy")
	def test_that_the_check_type_of_card_function_raises_validation_when_argument_is_a_non_numeric_string(self):
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
		self.assertRaises(TypeError, check_card_number_length, "mummy")
	def test_that_the_check_card_number_length_function_raises_validation_when_argument_is_a_non_numeric_string(self):
		self.assertRaises(ValueError, check_card_number_length, "")
	def test_that_the_check_card_number_length_function_returns_correct_result(self):
		result = check_card_number_length("5399831619690404")
		self.assertEqual(result, '16')



	
	
	
	
	
	
	
	
	
	