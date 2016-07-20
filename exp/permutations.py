
def permutate(a):
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
			
			for k in permutate(m):
				k.insert(0, i)
				yield k
			
def f(a):
	for i in a:
		for j in a:
			for k in a:
				if not(i==j) and not(i==k) and not(j==k):
					print i, j, k
	
	

	
l = [1,2,3]

#f(l)
for i in permutate(l):
	print i