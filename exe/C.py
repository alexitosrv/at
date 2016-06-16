

def get_neighbors(population, i, j, rows, columns, strength):

	if ( i-1 >= 0 ):
		if (population[i-1][j] != -1 and population[i-1][j] <= strength):
			yield [i-1, j]
		
	if ( j-1 >= 0 ):
		if (population[i][j-1] != -1 and population[i][j-1] <= strength):
			yield [i, j-1]
	
	if ( j+1 < columns ):
		if (population[i][j+1] != -1 and population[i][j+1] <= strength):
			yield [i, j+1]
	
	if ( i+1 < rows ):
		if (population[i+1][j] != -1 and population[i+1][j] <= strength):
			yield [i+1, j]
		
	
def infect_and_hunt(population, y, x, rows, columns, strength):

	neighbors = get_neighbors(population, y, x, rows, columns, strength)
	
	for n in neighbors:
		i = n[0]
		j = n[1]
		if ( 0 <= population[i][j]):
			if ( population[i][j] <= strength ):
				population[i][j] = -1
				infect_and_hunt(population, i, j, rows, columns, strength)

	
def answer(population, x, y, strength):
	
	rows = len(population)
	columns = len(population[0])

	if ( 0 <= population[y][x] and population[y][x] <= strength ):
		population[y][x] = -1	

	infect_and_hunt(population, y, x, rows, columns, strength)

	return population

	

#population = [[1, 2, 3], [2, 3, 4], [3, 2, 1]]
#y = 0
#x = 0
#strength = 2

## [[-1, -1, 3], [-1, 3, 4], [3, 2, 1]]

population = [[6, 7, 2, 7, 6], [6, 3, 1, 4, 7], [0, 2, 4, 1, 10], [8, 1, 1, 4, 9], [8, 7, 4, 9, 9]] 
x = 2 
y = 1 
strength = 5 

#population = [[9, 3, 4, 5, 4], [1, 6, 5, 4, 3], [2, 3, 7, 3, 2], [3, 4, 5, 8, 1], [4, 5, 4, 3, 9]]
#y = 2
#x = 1
#strength = 5

#population = [[9, 3, 4, 5, 4], [1, 6, 5, 4, 3], [2, 3, 7, 3, 2]]
#y = 2
#x = 1
#strength = 5

print(answer(population, x, y, strength))
				
