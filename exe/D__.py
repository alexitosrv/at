import time

from itertools import combinations

def ppp(s):
	for i in s:
		print i


def get_positions_for_sub(c, w):
	positions=list()
	
	i = chunk.find(word)
	while i>=0:
		positions.append(i)
		i = chunk.find(word, i+1)
	return positions
	
def get_pairs_of_affected_subs(positions, n, m):
	affected = list()
	i = 0
	while i<n-1:
		j = i
		while j<n:
			affected.append([positions[i], positions[i]+m])
			j = j+1
		i=i+1
	return affected

def is_idx_outside_all_tuples_in_range(idx, r):
	is_inside_range = idx >= r[j][0] and idx <= r[-1][1]
	is_not_inside_tuple_j = True
	j = 0
	while is_inside_range and is_not_inside_tuple_j:
		is_not_inside_tuple_j = not(r[j][0]<idx<r[j][1])
		j = j+1
		
	return is_not_inside_tuple_j
	
	#3,true
	#5,false
	#12,
	#
	#4,8
	#10,15
	
def generate_subs(c, positions):
	# this function will generate all the possible substrings in c
	# where the positions are wiped out
	for i in combinations(c, len(positions)-1)
		s = list()

		for idx,k in enumerate(c):
			if is_idx_outside_all_tuples_in_range(idx,i):
				s.append(k)
		yield str(s)
				
			

def answer(chunk, word):

	# idea: find all places where word is in chunk and store them in positions
	n = len(chunk)
	m = len(word)
	position = get_positions_for_sub(chunk, word)
	affected = get_pairs_of_affected_subs(positions,n,m)
	shortest_len = 21
	
	candidates = list()
	
	for i in generate_subs(chunk, affected):
		length_i = len(i)
		if length_i < shortest_len:
			shortest_len = len(i)
			candidates.pop(0)
			candidates.insert(0, i)
		else:
			if length_i == shortest_len and i not in candidates:
				candidates.append(i)
	
	print 'n', n, 'm', m
	print 'positions'
	ppp(positions)
	
	# if the intervals don't overlap is easy, 
	# if the intervals overlap, that is one case
	# because i need to deactivate the replacement on the overlap

	candidates.sort()
	return candidates[0]


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
answer(c, w)#+'|')
#print(answer(c, w))