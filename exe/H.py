
def is_valid(p,x,n,y):
	i = 0
	
	while i<n and p[i]!=n:
		i = i+1
	
	# p[i] == n or i==n
	if i == n:
		return False
	
	print "i es", i
	m = 0
	k = 0
	
	for j in range(i+1):
		if p[j] > m:
			m = p[j]
			k = k+1
			
	if k != x:
		return False

	m = 0
	k = 0
	
	for j in range(n-1,i-1,-1):
		if p[j] > m:
			m = p[j]
			k = k+1
		
	if k != y:
		return False
		
	return True
	

	
def generate_permutations(a):
	def copy_list_without_i(a,i):
		m = []
		for j in a:
			if i!=j:
				m.append(j)
		return m

	if len(a) == 2:
		yield [a[0], a[1]]
		yield [a[1], a[0]]
	else:
		for i in a:
			m = copy_list_without_i(a,i)
			
			for k in generate_permutations(m):
				k.insert(0, i)
				yield k	
	



## x 
def answer(x,y,n):
	pass

	### 1,2,3,4,5,...,n
	
	### seeing x, from west
	### seeing y, from east
	
	

x = 2
y = 4
n = 6
	
p = [ 5, 6, 4, 3, 1, 2 ]
print is_valid(p, x, n, y)
p = [ 5, 6, 4, 1, 3, 2 ]
print is_valid(p, x, n, y)
p = [ 5, 6, 1, 4, 3, 2 ]
print is_valid(p, x, n, y)
p = [ 5, 1, 6, 4, 3, 2 ]
print is_valid(p, x, n, y)
p = [ 4, 6, 5, 3, 1, 2 ]
print is_valid(p, x, n, y)
p = [ 4, 6, 5, 1, 3, 2 ]
print is_valid(p, x, n, y)
p = [ 4, 6, 1, 5, 3, 2 ]
print is_valid(p, x, n, y)
p = [ 4, 1, 6, 5, 3, 2 ]
print is_valid(p, x, n, y)
p = [ 3, 6, 5, 4, 1, 2 ]
print is_valid(p, x, n, y)
p = [ 3, 6, 5, 1, 4, 2 ]
print is_valid(p, x, n, y)
p = [ 3, 6, 1, 5, 4, 2 ]
print is_valid(p, x, n, y)
p = [ 3, 1, 6, 5, 4, 2 ]
print is_valid(p, x, n, y)
p = [ 2, 6, 5, 4, 1, 3 ]
print is_valid(p, x, n, y)
p = [ 2, 6, 5, 1, 4, 3 ]
print is_valid(p, x, n, y)
p = [ 2, 6, 1, 5, 4, 3 ]
print is_valid(p, x, n, y)
p = [ 2, 1, 6, 5, 4, 3 ]
print is_valid(p, x, n, y)
p = [ 1, 6, 5, 4, 2, 3 ]
print is_valid(p, x, n, y)
p = [ 1, 6, 5, 2, 4, 3 ]
print is_valid(p, x, n, y)
p = [ 1, 6, 2, 5, 4, 3 ]
print is_valid(p, x, n, y)

p = [ 6, 2, 5, 4, 3, 1 ]
print is_valid(p, x, n, y)



