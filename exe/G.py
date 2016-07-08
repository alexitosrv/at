


def R_(n):
	if n == 0:
		return 1
	
	if n == 1:
		return 1
	
	if n == 2:
		return 2
	
	n_ = n / 2
	if n % 2 == 0:
		return R_(n_) + R_(n_+1) + n_

	return R_(n_-1) + R_(n_) + 1

	

def answer(str_S):

	m = {}

	m[0] = 1
	m[1] = 1
	m[2] = 2

	def R(n):
		if n not in m:
			n_ = n / 2
			if n % 2 == 0:
				m[n] = R(n_) + R(n_+1) + n_
			else:	
				m[n] = R(n_-1) + R(n_) + 1
		
		return m[n]
		
	s = long(str_S)
	n = 0
	r = 0
	
	while True:
		r = R(n)
		
		if r == s:
			return str(n)
		
		#if r/2 s/2:
		
		n = n+1

	return 'None'
	
	
print answer('6')
print answer('7')
print answer('100')
#for n in range(50):
#	print n, R(n)
