## Домашнее задание 6

## Задача 1

Написать программу, которая считывает с консоли строку определенного формата</br> 
или несколько строк.</br>
Затем получает на основании введенных данных определенную дату и говорит,</br>
какой в этот день был день недели.</br>
Для того, чтобы вывести день недели на русском языке следует использовать</br> 
date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("ru"))</br>
В случае, когда неверно введена дата, пользователю на консоль выводится сообщение</br>
"Введенные данные некорректны."</br>
А затем снова предлагает ввести дату.</br>
Если данные введены верно, то программа выводит на экран введеннную дату</br>
и русскооязычное название дня недели, после чего завершается.</br>
Формат вводимой строки для даты выбрать самостоятельно.</br>