
def find_candidates(s, t, m):
	k = 0
	still_looking = True
	while still_looking:
		k = s.find(t, k)
		if k >= 0:
			yield s[:k]+s[k+m:] 
			k = k+1
		else:
			still_looking = False

def answer(chunk, word):
	r = chunk
	m = len(word)
	candidates = list()
	candidates.append(chunk)
	passed_over = set()

	while len(candidates):
		v = candidates.pop()
		for c in find_candidates(v, word, m):
			if c not in passed_over:
				if len(c) == len(r):
					r = min(c, r)
				elif len(c) < len(r):
					r = c
				passed_over.add(c)
				candidates.append(c)
	return r

#def defiddle(s, t):
#    
#	n = len(s)
#	m = len(t)
#	k = s.find(t)
#	ks = list()
#	while k>= 0:
#		ks.append(k)
#		k = s.find(t,k+1)
#	#print'ks',ks
#	i = 0
#	is_overlap = False
#	for idx,k in enumerate(ks[:-1]):
#		if ks[idx]+m>=ks[idx+1]:
#			is_overlap = True
#	
#	if is_overlap:
#		h = 0
#		while h < len(ks):
#			#print 'ks[h]',ks[h]
#			#print 's',s
#			#print 's y s\'',s[:ks[h]+m-1]+']['+s[ks[h]+m-1:]
#			#yield s[:ks[h]+m-1].replace(t,'')+s[ks[h]+m-1:].replace(t,'')
#			yield s[:ks[h]+m]+s[ks[h]+m:]
#			h = h+1
#	
#		# if (k<m and t in s[k+m:]):
#			# yield s[k:k+m]+s[k+m:].replace(t, '')
#	else:
#		#print 's', s
#		v = s.replace(t, '')
#		#print 'v', v
#		#print 't', t
#		
#		while t in v:
#			v = v.replace(t, '')
#		yield v
#			
#
###def answer(chunk, word):
##	m = len(word)
##	n = len(chunk)
##	candidates = list()
##	candidates.append('')
##	shortest_len = 1000
##	seen = set() 
##	
##	for i in defiddle(chunk, word):
##		#print '|'+i+'|'
##		length_i = len(i)
##		if length_i < shortest_len:
##			shortest_len = len(i)
##			candidates.pop(0)
##			candidates.insert(0, i)
##		else:
##			if length_i == shortest_len and i not in candidates:
##				candidates.append(i)
##
##	candidates.sort()
##	return candidates[0]

#c = 'aaaaaaabbbbbbb'
#c = 'ababb'
#w ='b'
#c = 'aabb'
#w = 'ab'
#c = 'lololololo'
#w = 'lol'
#c = 'ab____ab____ab'
#w = 'ab'
#c = 'lolol'
#w = 'lol'
#c = 'abc'
#w = 'abc'
	
c = 'lololololo'
w = 'lol'

#c = 'goodgooogoogfogoood'
#w = 'goo'
#w = 'goo'
#
#c = 'aabb'
#w = 'ab'

#c = 'odogdogodgo'
#w = 'god'
print('|'+answer(c, w)+'|')
#print answer(c, w)