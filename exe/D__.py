import time

from itertools import combinations

def pp(s):
	for i,j in enumerate(s):
		print i, j
		
def ppp(s):
	for i in s:
		print i


def get_positions_for_sub(c, w, m):
	starts=list()
	positions=list()
	overlaps=list()
	i = c.find(w)
	
	while i>=0:
		starts.append(i)
		for j in range(i,i+m):
			if j in positions:
				overlaps.append(j)
			positions.append(j)
		i = c.find(w, i+1)
	return starts, positions, overlaps
	
	
	return ''.join(s)

def replace2(cc, pos, n):
	s = list()
	for i in range(n):
		if i not in pos:
			s.append(cc[i])
	return ''.join(s)
	
def generate_substrings(c, starts, positions, overlaps, n, m):
	if len(overlaps) == 0:
		return replace2(c, positions, n)
	else:
		p = list()
		print
		print
		print 'hay overlap '
		print
		print
		print 'c', list(c)
		print '  ', range(n)
		k = 0
		
		# for i in starts: # se recorren todos los pedazos en los que est'a w
			# #if i+m-1 in positions:
			# s = str()
			# for idx, k in enumerate(c):
				# if idx < i :
					# s = s + c[idx]
				# else:
					# if i <= idx < i+m :
						# pass
					# else:
						# if i+m+1 <= idx < n :
							# if idx not in overlaps:
								# s = s + c[idx]
			
		#	print 'i a i+m', range(i,i+m)
			# print
			# print
			# print 'antes',c[:i]
			# print 'durante',c[i:i+m]
			# print 'despues',c[i+m+1:]
		#	for j in range(i,i+m):
		#		if j not in overlaps:
		#			print c[j]
		#	#print 
		#	#print
		#	#print 'i+m-1=', i+m-1
		
		#	print '       ', range(n)
		#	#print '   ' ,range(i+m-1)
			#print c[:i+m-1]
			#print c[:i+m-1]
			
		return None
			

		

def answer(chunk, word):

	# idea: find all places where word is in chunk and store them in positions
	n = len(chunk)
	m = len(word)
	starts, positions, overlaps = get_positions_for_sub(chunk, word, m)
	print 'starts', starts
	print 'positions', positions
	print 'overlaps', overlaps
	print 'idx', range(n)
	#shortest_len = 21
	#candidates = list()
	#pp(chunk)
	#for i in 
	print generate_substrings(chunk, starts, positions, overlaps, n, m)
	#	print 
	#for i in generate_subs(chunk, affected, n, m):
	#	length_i = len(i)
	#	if length_i < shortest_len:
	#		shortest_len = len(i)
	#		candidates.pop(0)
	#		candidates.insert(0, i)
	#	else:
	#		if length_i == shortest_len and i not in candidates:
	#			candidates.append(i)
	
	#print 'n', n, 'm', m
	#print 'positions'
	#ppp(positions)
	
	# if the intervals don't overlap is easy, 
	# if the intervals overlap, that is one case
	# because i need to deactivate the replacement on the overlap

	#candidates.sort()
	#return candidates[0]
	
	
#c = 'lololololo'
#w = 'lol'
#c = 'ab____ab____ab'
#w = 'ab'
c = 'lolol'
w = 'lol'
#c = 'abc'
#w = 'abc'
	
#c = 'lololololo'
#w = 'lol'

#c = 'goodgooogoogfogoood'
#w = 'goo'
#
#c = 'aabb'
#w = 'ab'
#print('|'+
#answer(c, w)#+'|')
answer(c, w)