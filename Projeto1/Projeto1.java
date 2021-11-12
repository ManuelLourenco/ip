public class Projeto1{
  public static void main(String[] args) {
    int num = 44521141;
    int ocurrenciasNum = 4;
    int digitos=digits(num);
    System.out.println(digitos);
    int ocurrencias = occurrencesOf(num,ocurrenciasNum);
    System.out.println(ocurrencias);
    boolean valido = isValid(num);
    System.out.println(valido);
    int numDireita = rightSubsequence (num,5);
    System.out.println(numDireita);
    boolean moverDireita = ableToMoveRight(num);
    System.out.println(moverDireita);
    boolean grid = isValidForGrid(num,8);
    System.out.println(grid);
  }
  /**
  *Dado um numero inteiro a função devolve o numero de digitos desse numero
  *
  *@param num numero inteiro dado
  *@requires {@code num>0}
  *@return  retorna o numero de digitos de num
  */
  private static int digits(int num){
    int contador = 0;
    while (num > 0){
      num /= 10;
      contador++;
    }
    return contador;
  }
  /**
  *Dado um numero e um digito de 1 a 9 calcula o nº de ocurrenciasNum
  *
  *@param num numero dado inteiro
  *@param d digito de 1 a 9
  *@requires {@code num>0 && d>0 && d<=9}
  *@ensures {@code \result>0}
  *@return nº de vezes que o digito ocorre no num dado
  */
  private static int occurrencesOf(int num, int d){
  int contador = 0;
  while(num > 0){
    if (num%10 == d) {
      contador++;
    }
    num /= 10;
    }
    return contador;
  }
  private static boolean isValid(int num){
    int contadorDe5 = 0;

    if (num < 0) {
      return false;
    }

    while (num > 0){
      if((num%10) == 5){
        contadorDe5++;
      }

      if ((num%10) > 5 || contadorDe5 > 1) {
        return false;
      }
      num /= 10;
  }
  return true;


}
private static int rightSubsequence(int num,int d){
    int soma = 0;
    int contador = 1;
    int contador2 = 0;
    int mult = 1;

    while(num>0){
      if (num%10 != d) {
        while(contador2<contador) {
          soma += (num%10) * mult;
          contador2++;
          mult *= 10;
        }
        contador += 1;
      }
      num /= 10;

      if (num%10 == d) {
        return soma;
      }
    }
        return 0;
    }
    public static boolean ableToMoveRight(int num){

    int nDepoisDe5 = rightSubsequence(num , 5);
    int nDigitos = digits(nDepoisDe5);
    int aux = nDepoisDe5;
    int primDigitoDepoisDeN = 0; //primeiro digito depois de n
    int segundDigitoDepoisDeN = 0; //segundo digito depois de n

    if (nDigitos>=2) { //aux vai ter o valor dos 2 numeros depois de n
      for (int i = 0; i < nDigitos-2; i++) {
      aux /= 10;
    }
    primDigitoDepoisDeN = aux/10;
    segundDigitoDepoisDeN = aux%10;
} else { //se só houver 1 digito
  primDigitoDepoisDeN = aux;
}

    if ( (nDepoisDe5>0 && primDigitoDepoisDeN%2!=0) || ((nDepoisDe5>10) && ((primDigitoDepoisDeN*segundDigitoDepoisDeN) % 4 != 0)) ) {
      return true; //se a ou b, é movivel para a direita
    }
    return false;
  }
   public static boolean isValidForGrid (int num , int numDigits ){
     if (isValid(num) && numDigits==digits(num)) {
       return true;
     }
       else{
       return false;}

   }





}
