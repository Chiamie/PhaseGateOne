def storeStudentScores(scores, sum, average):
	storedScores = {}
	count = 1
	#key = 'subject' + str(count)
	
	for number in range(0, len(scores)):
		storedScores['subject' + str(count)] = scores[number]
		count += 1
	storedScores['Total'] = sum
	storedScores['Average'] = average
	
	return storedScores;


def get_class_position_of(class_scores):
	class_average = []
	for student in range(0, len(class_scores)):
		for key in class_scores[student]:
			if key == "Average":
				class_average.append(class_scores[student][key])
	class_position_list = sorted(class_average, reverse = True)
	return class_position_list

		
def get_student_position(class_scores, class_position_list):
	position = 1
	for count in range(0, len(class_position_list)):
		for student in class_scores:
			if student['Average'] == class_position_list[count]:
				student['Position'] = position
				position += 1
	return class_scores

				
def get_highest_score_of_subject1(class_scores):
	largest = 0
	smallest = -1
	count = 0	
	for student in class_scores:
		if student['subject1'] > largest:
			largest = student['subject1']	
	return class_scores.index(student)
	
def get_smallest_score_of_subject1(class_scores):
	smallest = -1
	count = 0	
	for student in class_scores:
		if student['subject1'] < smallest:
			smallest = student['subject1']	
	return class_scores.index(student)

def get_total_score_of_subject1(class_scores):
	sum = 0	
	for student in range(0, len(class_scores)):
		for key in class_scores[student]:
			if key == "subject1":
				sum += class_scores[student][key] 
		
	return sum

def get_pass_and_fail_count_of_subject1(class_scores):
	pass_count = 0
	fail_count = 0	
	for student in class_scores:
		if student['subject1'] > 50:
			pass_count += 1
		else:
			fail_count += 1
	return (pass_count, fail_count)


number_of_students = int(input("Enter the number of students in your class: "))
number_of_subjects = int(input("Enter the number of subjects offered: "))
print("Saving >>>>>>>>>>>>>>>>>>>>>>")
print("Saved successfully")
student1 = []

for student in range(1, number_of_students + 1):
	scores = []
	sum = 0
	average = 0
	for subject in range(1, number_of_subjects + 1):
		print(f"Entering score for student {student} ")
		score = int(input(f"Enter score for subject {subject} " ))
		sum += score

		print("Saving >>>>>>>>>>>>>>>>>>>>>>")
		print("Saved successfully")

		scores.append(score)
	average = sum / number_of_subjects
	student1.append(storeStudentScores(scores, sum, average))
	
print(student1)

class_position_list = get_class_position_of(student1)
each_student_position = get_student_position(student1, class_position_list)
print(each_student_position)

index_highest_scoring_student = get_highest_score_of_subject1(each_student_position)
index_smallest_scoring_student = get_smallest_score_of_subject1(student1)
subject1_total_score = get_total_score_of_subject1(student1)
subject1_average_score = subject1_total_score / number_of_students
number_of_passes, number_of_fails = get_pass_and_fail_count_of_subject1(student1)


print(f"Highest scoring student is: Student {index_highest_scoring_student + 1}")
print(f"Lowest scoring student is: Student {index_smallest_scoring_student + 1}")
print(f"Total Score is: {subject1_total_score}")
print(f"Average score is: {subject1_average_score}")
print(f"Number of passes: {number_of_passes}")
print(f"Number of fails: {number_of_fails}")








print("STUDENT\tSUB1\tSUB2\tSUB3\tTOTAL\tAverage\tPOSITION")
for row in each_student_position:
	print(("Student1"+ "\t".join(str(value) for value in row.values())))





	









