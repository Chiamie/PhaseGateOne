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

def get_total_score_of_subjects_in(class_scores):
	subject_sums = {}
	for student in class_scores:
		for subject, score in student.items():
			if subject not in ['Name', 'Total', 'Average', 'Position']:
				if subject in subject_sums:
					subject_sums[subject] += score
				else:
					subject_sums[subject] = score
	return subject_sums

def get_highest_score_of_subjects(class_scores):
	subject_max = {}
	subject_max_index = {}
	for number in range(len(class_scores)):
		student = class_scores[number]
		for subject, score in student.items():
			if subject not in ['Total', 'Average', 'Position']:
				if subject in subject_max:
					if score > subject_max[subject]:
						subject_max[subject] = score
						subject_max_index[subject] = number
				else:
					subject_max[subject] = score
					subject_max_index[subject] = number
					
	return subject_max, subject_max_index	

def get_smallest_score_of_subjects(class_scores):
	subject_min = {}
	subject_min_index = {}
	for number in range(len(class_scores)):
		student = class_scores[number]
		for subject, score in student.items():
			if subject not in ['Total', 'Average', 'Position']:
				if subject in subject_min:
					if score < subject_min[subject]:
						subject_min[subject] = score
						subject_min_index[subject] = number
				else:
					subject_min[subject] = score
					subject_min_index[subject] = number
	return subject_min, subject_min_index

def get_pass_and_fail_count_of_subjects(class_scores):
	performance_count = {}
	pass_count = 0
	fail_count = 0	
	for student in class_scores:
		for subject, score in student.items():
			if subject not in ['Total', 'Average', 'Position']:
				if subject not in performance_count:
					performance_count[subject] = {'pass': 0, 'fail': 0}
				if score > 50:
					performance_count[subject]['pass'] += 1 
				else:
					performance_count[subject]['fail'] += 1
	return performance_count



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
		while score < 0 or score > 100:
			print("Incorrect input")
			print(f"Entering score for student {student} ")
			score = int(input(f"Enter score for subject {subject} " ))
		sum += score

		print("Saving >>>>>>>>>>>>>>>>>>>>>>")
		print("Saved successfully")

		scores.append(score)
	average = sum / number_of_subjects
	student1.append(storeStudentScores(scores, sum, average))
	
class_position_list = get_class_position_of(student1)
each_student_position = get_student_position(student1, class_position_list)



total_subject_score = get_total_score_of_subjects_in(student1)
highest_scores, top_scorer_indices = get_highest_score_of_subjects(student1)
lowest_scores, low_scorer_indices = get_smallest_score_of_subjects(student1)




print("STUDENT\tSUB1\tSUB2\tSUB3\tTOTAL\tAverage\tPOSITION")
for row in each_student_position:
	print(("Student1"+ "\t".join(str(value) for value in row.values())))



print("SUBJECT SUMMARY")

for number in range(number_of_subjects):
	print(f"Subject {number + 1}")
	print(f"Highest scoring student is: Student {list(top_scorer_indices.values())[number] + 1} scoring {list(highest_scores.values())[number]}")
	print(f"Lowest scoring student is: Student {list(low_scorer_indices.values())[number] + 1} scoring {list(lowest_scores.values())[number]}")
	print(f"Total Score is: {list(total_subject_score.values())[number]}")
	print(f"Average score is: {(list(total_subject_score.values())[number]) / number_of_students}")
	















	












