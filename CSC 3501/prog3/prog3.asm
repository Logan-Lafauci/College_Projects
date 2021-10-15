.global check_cache

#Name: Logan Lafauci
#ID Number: 892431322
check_cache:
	pushl   %ebp
        movl    %esp,   %ebp

	#implement here
	#we are working with 1 bytes/8 bits of data
	#s = 2 bits. b = 2 bits. t = 4 bits.
	#This grabs our unsigned char address
	movl 	12(%ebp), %edx
	# this assigns our cache to esi
	movl	8(%ebp), %esi
	# this variable will be used to get the b bits
	movb	$3, %cl
	# this uses and on %dl to get the b bits 
	andb	%dl, %cl
	# this right shifts so I can get the s bits
	shrb	$2, %dl
	# this variable is used to get the s bits
	movb	$3, %ch
	# this uses and on %dl to get the s bits
	andb	%dl, %ch
	# this shifts the adres to leave the remaining t bits
	shrb	$2, %dl
	# this sets eax to 6 to move through the cache
	movl	$6, %eax
	# this multiplies the set bit and eax to look at the correct set
	imul 	%ch
	# This is moving to the set we want to look at
	leal 	(%esi, %eax), %esi
	# this sets eax to be used to compare 
	movl	(%esi), %eax
	# this checks if the value in the cache is 0
	cmpb	$1, %al
	# this jumps to code that sets the return to miss
	jne .L1
	# this sets eax to the tag bits to test if it is a miss or hit
	movl 	1(%esi), %eax
	# this compares the cache tag bits and the tag bits we got
	cmpb	%dl, %al
	# this jumps to our miss code if they are not the same
	jne .L1
	# this sets eax to 2 to move pass the t and s bits
	movl	$2, %eax
	# this adds the b bits to that so we are looking at the right block
	addb 	%cl, %al
	# this moves the %esi to the correct block
	leal	(%esi, %eax), %esi
	# this sets the %esi block to the return value
	movl	(%esi), %eax
	# this moves pass the part that sets our return to miss
	jmp .L2
	#this jumps to the point where we set %al to 0xff
.L1:
	#this sets the return value to 0xff
	movb	$0xff, %al
	# this jumps past the return value getting set to miss
.L2: 
	popl    %ebp
        ret
