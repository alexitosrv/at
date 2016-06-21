def answer(heights):
	n = len(heights)
	i = 0
	z = 0
	partial = 1
	d2 = 0
	left_side = 0
	right_side = 0
	
	while (i<n-1):
		
		d2 = heights[i]-heights[i+1]
		
		print 'i',str(i)+', heights at i and i+1',heights[i],heights[i+1], ', d2=', d2
		
		if (d2 == 0):
			# here I continue what was happening before
			#
			#
			#
			# ________________
			# sum 1 to partial
			partial = partial +1
		else:
			if (d2 < 0):
			# this must be the rigth end of the wall
			#       |
			#       |
			#       |
			# ______|
			
			# or there is nothing that forms a bucket there

			# or let's look for the possibility of having more negative diferences 
			# and then stop until we get a zero or positive one
			#        ____
			#       |
			#       |
			#    ---|
			# ___|
				print 'left and r', left_side, right_side
				if left_side > 0:
					right_side = abs(d2)
					print 'right_side', right_side
					z = z + min (left_side, right_side) * partial 
					print 'new z',z
					i = i+1
					partial = partial +1
					
					if (i<n-1):
						d2 = heights[i]-heights[i+1]
						print '* i',str(i)+', heights at i and i+1',heights[i],heights[i+1], ', d2=', d2, ' z=', z
					else:
						break
					
					while(d2<0 and i<n-1):
						right_side = abs(d2)
						z = z + min (left_side, right_side) * partial 
						i = i+1
						partial = partial +1
						
						if (i<n-1):
							d2 = heights[i]-heights[i+1]
						else:
							break
					
					# restart partial and left side
					left_side = 0
					partial = 1
			else:
			# this must be the left end of the wall 
			# 
			# |
			# |
			# |__________
				left_side = d2
				partial = 1

		i =i+1
			
	
	return z
	
h = [1, 4, 2, 5, 1, 2, 3]
print answer(h)