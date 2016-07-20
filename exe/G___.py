m = {}
m[0] = 1
m[1] = 1
m[2] = 2

def R(n):
	if n in m:
		return m[n]
		
	n_ = n // 2
	
	if n % 2 == 0:
		m[n] = R(n_+1) + R(n_) + n_
	else:	
		m[n] = R(n_-1) + R(n_) + 1

	return m[n]

			
def bs(low, high, S, parity):
	while True:
		if high <= low:
			return None

		n = low + ((high - low) // 2)
		
		current_parity = n % 2
		parity_changes = parity != current_parity # el problema era que con este cambio de paridad cambia la condici'on de terminaci'on y en las siguientes iteraciones puede resultar que no se evaluan correctamente los demas puntos
		
		n = n + (1 if parity_changes else 0)

		r = R(n)

		if r == S:
			return n

		if r > S:
			high = n - 1
		else:
			low = n + 1	
	
	
def answer(str_S):
		
	s = long(str_S)

	# create a range to look for the answer knowing that if s have k-digits, then n will have at most k-digits

	return bs(0, 10**len(str_S), s, 1) or \
	       bs(0, 10**len(str_S), s, 0)
	

	
print answer('4')
print answer('22')
print answer('992')
print answer('2915')
print answer('3418')
print answer('13')
print answer('7')
print answer('100')
print answer('532')
print answer('186832')
print answer('186835')
print answer('217026840050179138061511387')
##
#for n in range(1,10 ** 3,1):
#	print n, R(n)
#print 10 ** 25, R(10 ** 25)
