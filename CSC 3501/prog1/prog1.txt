void int2bitstr(int I, char *str) {
	/*This loops through the avaliable spot in the string*/
	for(int i = 31; i >= 0; i--)
	{
		//This checks if th right most bit is 1 or zero
		if((I & 0x1) == 1)
		{
			//this adds a one to the string when the right most bit is one
			str[i] = '1';
		}
		else
		{
			//this adds a zero to the string when the right most bit is zero
			str[i] = '0';
		}
		//This right shifts the integer for the next iteration
		I >>= 1;
	}
	//This is the null-terminator
	str[32] = '\0';
}

int get_exp_value(float f) {
	unsigned f2u(float f);
	unsigned int ui = f2u(f);
	//Bias is used in the calulations to get E
	int bias = 127;
	//This gets our ui to have the exp value as the eight right most bits since we are working in a 32 bit system
	ui >>= 23;
	//This get's our exponent value and eleminates any ones from right shifting as well as the signed value 255 = 2^8 - 1
	int exp = ui & 255;
	//This calculates the biased exponent value
	int e = exp - bias;
	//This if statement checks for denormalized values 
	if(exp == 0)
	{
		//This returns E which is stated to be 1 - Bias
		return(1 - bias);
	}
	//This if statement detects if a number is special like infinity or NaN
	if(exp == 255)
	{
		//This is the value told to output for when values are special
		return(-128);
	}
	//This returns the bias exponent
	return e;
}
