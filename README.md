# RUT_validator
Validator of chilean RUT

This code is used to verify if a RUT (Rol Único Tributario) is valid or not. A RUT is a personal identification number used in Chile, which consists of a number and a verifier letter.

The Main class has a method called isValidRut, which receives a string as parameter representing the RUT to be verified. This method is responsible for dividing the RUT into two parts using the split method and a separator "-". Then it verifies if the first part (which corresponds to the number of the RUT) is composed only by digits and if the second part (which corresponds to the verifier letter) is a valid character (a digit or the letter "k" or "K"). If any of these conditions is not met, the method returns false.

If both parts of the RUT are valid, the method proceeds to calculate the verifier letter that the RUT should have according to a specific algorithm. First it reverses the order of the digits of the number of the RUT, then it does a series of calculations with them and finally determines the verifier letter that corresponds to the obtained result. If the calculated verifier letter coincides with the verifier letter of the RUT being verified, the method returns true, indicating that the RUT is valid. If it does not coincide, it returns false.

The Main class also has a main method, which is the main method of the program. This method uses the Scanner class from the java.util library to read a line of text from the keyboard (which should be a RUT) and then uses the isValidRut method to verify if the RUT is valid or not. If the RUT is valid, it prints a message indicating that it is valid, otherwise it prints a message indicating that it is not valid.
