# Аттестационное задание по курсу DEV-J60.

Описание учебной задачи "Система хранения пользовательских данных"

## Общее описание

Система представляет собой многопользовательское веб-приложение, которое позволяет пользователям заносить в базу данных набор произвольных параметров, каждый из которых имеет вид "имя_данных" - "значение". Также пользователь может запрашивать из базы данных список всех данных и данные по имени. Имя данных представляет собой непустую строку длиной до 255 символов. Значение представляет собой целое число типа int.

## Реализация

Реализация приложения выполняется в 3 этапа.

### Первый этап 

Включает реализацию на основе технологии сервлетов нескольких классов.

#### Класс сервлета Registrator

Обеспечивает ввод одного параметра, который включает:
- имя параметра - непустая строка длиной до 255 символов;
- значение параметра - целое число.

Класс показывает пользователю результат выполнения операции ввода:
- введённый параметр добавлен как новый;
- введённый параметр заменил ранее введённый параметр в случае, когда параметр с таким именем уже присутствует в системе;
- введён неправильный параметр с указанием типа ошибки:
  - имя параметра пустое или превышает длину 255 символa;
  - значение параметра не может быть корректно преобразовано к типу int;
- класс позволяет пользователю вызвать форму для просмотра введённых параметров (класс ViewList).

#### Класс сервлета ViewList

Обеспечивает показ пользователю имён и значений введённых параметров:
- всех параметров (по умолчанию);
- всех параметров, удовлетворяющих заданному пользователем шаблону имени;
- всех параметров, значение которых укладывается в заданный пользователем интервал;
- класс позволяет пользователю вызвать форму для ввода новых параметров (класс Registrator).

#### Класс Attribute

Обеспечивает хранение введённых пользователем параметров в виде коллекции объектов типа Parameter.

Требования к реализации:
- класс должен быть доступен всем сервлетам приложения;
- класс обеспечивает выполнение запросов от класса ViewList. 

#### Класс Parameter

Представляет отдельный параметр, который содержит:
- имя параметра - непустая строка длиной до 255 символов;
- значение параметра - представляет собой целое число типа int;
- класс обеспечивает;
- задание начальных значений имени и значения параметра:
  - замену значения параметра с конвертацией из типа String;
  - получение имени параметра;
  - получение значения параметра;
  - конвертацию имени и значения параметра в строку вида "\<li\>имя_параметра \- значение_параметра\<\/li\>".

### Второй этап

Приложение расширяется за счёт подключения двух сессионных бинов со следующей функциональностью.

#### Класс UpdateBean типа @Stateless

Обеспечивает обработку запросов на изменение данных:
- занесение нового параметра в базу данных;
- изменение существующего параметра в базе данных;
- удаление существующего параметра из базы данных.

Класс должен обеспечить корректировку введённых пользователем значений и проверку допустимости значений полей перед занесением их в базу данных, а именно:
- из поля имени параметра удаляются пробельными символами в его начале и в конце. К пробельным символам относятся пробел, символ табуляции, символы начала новой строки и перевода каретки;
- поле имени параметра должно содержать не менее одного непробельного символа;
- длина поля имени параметра не должна превышать 255 символов после удаления начальных и конечных пробельных символов;
- поле значения параметра может быть корректно преобразовано в значение типа int.

#### Класс SelectBean типа @Stateless

Обеспечивает выполнение запросов от класса ViewList к базе данных на получение выборки.

Класс должен обрабатывать следующие виды запросов:
- получение всех записей;
- получение одной записи по имени параметра;
- получение всех записей, имена параметров которых удовлетворяют заданному пользователем шаблону. Шаблон может использовать метасимволы %(знак процента) для обозначения любого количества любых символов и _ (знак подчёркивания) для обозначения любого одного символа;
- в случае получения непустой выборки класс возвращает полученные результаты классу ViewList в виде HTML-представления полученных данных;
- в случае получения пустой выборки формируется строка с соответствующим сообщением.

### Третий этап

На  третьем этапе в приложение вводится класс DbManager типа @Singleton. Данный класс обеспечивает взаимодействие с базой данных на основе технологии JPA.

Данный класс обеспечивает выполнение следующих функций:
  - установку и поддержание соединения с базой данных;
  - управление объектами вида Entity;
  - непосредственное выполнение запросов от классов UpdateBean и SelectBean.
