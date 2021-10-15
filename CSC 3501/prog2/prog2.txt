.globl prog2

#your full name: Logan Lafauci
#your LSU ID number: 892431322

prog2:
	pushl	%ebp
	#implement here
	#this moves the base pointer to the part of the stack we are working in
	movl %esp, %ebp
	#this is the register for i
	movl 8(%ebp), %edi
	#this is the register for j
	movl 12(%ebp), %esi
	#this is the register for *k
	movl 16(%ebp), %edx
	#this is the register for *l
	movl 40(%ebp), %ecx
	#this is subtracting j-i
	subl %edi, %esi
	#this sets the return value to j-i
	movl %esi, %eax
	#this sets the register back to it's original value 
	addl %edi, %esi
	#this is saving k so we can get k*5 without multiplying 
	movl %edx, %r8d
	#this adds a[0] to *l
	addl 20(%edp), %ecx
	#this adds a[1] to *l
	addl 24(%edp), %ecx
	#this adds a[2] to *l
	addl 28(%edp), %ecx
	#this adds a[3] to *l
	addl 32(%edp), %ecx
	#this adds a[4] to *l
	addl 36(%edp), %ecx
	#this pops %ebp
	popl %ebp
	#this is returning the subtracted value
	ret
