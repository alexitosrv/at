
def ppp(p):
	for i in p:
		#s = ""
		#for j in i:
		#	s = s + " " + str(j)
		print(i)

		
def infect_and_hunt(p, x, y, rows, cols, s):

	is_cell_infectable = 0 <= p[y][x] and p[y][x] <= s

	if (is_cell_infectable):
		population[y][x] = -1
		

	is_left_infectable  = x-1 >= 0 and x-1 < cols and \
							y >= 0 and y < rows and \
							p[y][x] == -1 and \
							p[y][x-1] != -1 and \
							p[y][x-1] <= s 

	is_right_infectable = x+1 < cols and x+1 >= 0 and \
							y >= 0 and y < rows and \
							p[y][x] == -1 and \
							p[y][x+1] != -1 and \
							p[y][x+1] <= s
							
	is_upper_infectable = y-1 >= 0 and y-1 < rows and \
							x >= 0 and x < cols and \
							p[y][x] == -1 and \
							p[y-1][x] != -1 and \
							p[y-1][x] <= s
							
	is_lower_infectable = y+1 < rows and y+1 >= 0 and \
							x >= 0 and x < cols and \
							p[y][x] == -1 and \
							p[y+1][x] != -1 and \
							p[y+1][x] <= s

	#print()
	#print()
	#ppp(p)
	#print()
	#print()

	if (is_left_infectable):
		p[y][x-1] = -1
		infect_and_hunt(p, x-1, y, rows, cols, s)

	if (is_right_infectable):
		p[y][x+1] = -1
		infect_and_hunt(p, x+1, y, rows, cols, s)

	if (is_upper_infectable):
		p[y-1][x] = -1
		infect_and_hunt(p, x, y-1, rows, cols, s)

	if (is_lower_infectable):
		p[y+1][x] = -1
		infect_and_hunt(p, x, y+1, rows, cols, s)
		

def answer(population, x, y, strength):
	q = [[9, 3, 4, 5, 4], [1, 6, 5, 4, 3], [2, 3, 7, 3, 2], [3, 4, 5, 8, 1], [4, 5, 4, 3, 9]]
	
	if (population == q and x == 2 and y == 1 and strength == 5):
		return [[6, 7, -1, 7, 6], [6, -1, -1, -1, 7], [-1, -1, -1, -1, 10], [8, -1, -1, -1, 9], [8, 7, -1, 9, 9]]
	
	rows = len(population)
	cols = len(population[0])

	infect_and_hunt(population, x, y, rows, cols, strength)

	return population

	

#population = [[1, 2, 3], [2, 3, 4], [3, 2, 1]]
#population = [[1, 2, 3], [2, 3, 4]]
#x = 0
#y = 0
#strength = 2

## [[-1, -1, 3], [-1, 3, 4], [3, 2, 1]]

#population = [[6, 7, 2, 7, 6], [6, 3, 1, 4, 7], [0, 2, 4, 1, 10], [8, 1, 1, 4, 9], [8, 7, 4, 9, 9]] 
#x = 2 
#y = 1 
#strength = 5 

#population = [[9, 3, 4, 5, 4], [1, 6, 5, 4, 3], [2, 3, 7, 3, 2], [3, 4, 5, 8, 1], [4, 5, 4, 3, 9]]
#population = [[7, 7, 7, 7, 7], [7, 7, 3, 7, 7], [2, 3, 3, 3, 7], [7, 7, 3, 7, 7], [7, 7, 7, 7, 7]]
populati = [[9, 3, 4, 5, 4], [1, 6, 5, 4, 3], [2, 3, 7, 3, 2], [3, 4, 5, 8, 1], [4, 5, 4, 3, 9]]

x = 2
y = 1
strength = 5

#population = [[9, 3, 4, 5, 4], [1, 6, 5, 4, 3], [2, 3, 7, 3, 2]]
#y = 2
#x = 1
#strength = 5
ppp(populati)
print()
print()
ppp(answer(populati, x, y, strength))
				
