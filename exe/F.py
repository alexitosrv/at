def answer(digest):
	message = []
	
	message_i_1 = 0 
	message.append([j for j in range(255) if ( (129 * j) ^ message_i_1) % 256 == digest[0] ][0])
	
	for i in range(1,16):
		message.append([j for j in range(255) if ( (129 * j) ^ message[i-1]) % 256 == digest[i] ][0])
	
	return message
	

	
digest = [0, 129, 3, 129, 7, 129, 3, 129, 15, 129, 3, 129, 7, 129, 3, 129]
print answer(digest)
# [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]

digest = [0, 129, 5, 141, 25, 137, 61, 149, 113, 145, 53, 157, 233, 185, 109, 165]

print answer(digest)
# [0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196, 225]
