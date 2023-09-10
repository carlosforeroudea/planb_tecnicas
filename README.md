# planb_tecnicas
Crear una aplicación que permita el manejo de cuentas bancarias. En el banco se tienen clientes personas naturales o personas jurídicas. Los empleados del banco están clasificados en Taquilleros, Jefe de sucursal y Gerente
Cada cuenta bancaria tendrá un titular, un saldo disponible, un monto máximo por transacción, un monto de sobregiro disponible y un máximo de transacciones permitidas por día.
La aplicación debe permitir realizar diferentes transacciones, estas son: consultar saldo, realizar depósitos y realizar retiros. En cada cuenta, para cada transacción se deben registrar la fecha y el lugar, además del monto en caso de que se trate de un depósito o de un retiro.
A la hora de realizar una transacción, la aplicación debe hacer algunas verificaciones, y avisar de forma apropiada en los siguientes casos:

* A la hora de realizar un retiro el saldo es insuficiente (teniendo en cuenta el monto de sobregiro disponible).
* El monto por el que se desea realizar un retiro o un depósito es inválido (por ejemplo, es negativo).
* El monto de la transacción (depósito o retiro) supera el monto máximo por transacción definido para la cuenta.
* Se superó el número de transacciones permitidas por día.
* Entrega el extracto de los movimientos de cuenta en un periodo de fechas específicas.
Entregables
Entregar en un archivo .ZIP:

* Por escrito, los supuestos que se tuvieron en cuenta.
* Carpeta del proyecto, incluyendo los archivos fuente (.java).
* El código fuente debe incluir:
o Las clases que soporten tanto las cuentas y las transacciones como las diferentes excepciones.
o Manejo de interfaces
o Ambiente gráfico (opcional)
o Manejo de fechas
