TASK DESCRIPTION:
Design and implement a JSON API using Hibernate/Spring/SpringMVC without frontend.

Build a voting system for deciding where to have lunch.

2 types of users: admin and regular users
Admin can input a restorant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
Users can vote on which restaurant they want to have lunch at
Only one vote counted per user
If user votes again the same day:
If it is before 11:00 we asume that he changed his mind.
If it is after 11:00 then it is too late, vote can't be changed
Each restorant provides new menu each day.

API DOCUMENTATION

Title:		VotingSystem

URL:		
/admin/lunch or /admin/lunch?restaurant=:restaurant_name 
			/user/lunch or /user/lunch?restaurant=:restaurant_name 
/users or /users/:id or /users?id=:id

For fixed urls: /users or /photos
For urls with parameters in them: /users/:id or /photos/:photo_id or /users?id=:id

Method	The request type 
GET | POST | DELETE | PUT
URL Params	If URL params exist, specify them in accordance with name mentioned in URL section. Separate into optional and required.
Required: 
id=[integer] 
example: id=12

Optional 
photo_id=[alphanumeric] 
example: photo_id=2345kj3

Data Params	If making a post request, what should the body payload look like?
This is a good time to document your various data constraints too. 
Example:
{
  u : {
    email : [string],
    name : [string],
    current_password : [alphanumeric]
    password : [alphanumeric],
    password_confirmation : [alphanumeric]
  }
}

Example:

{
  u : {
    email : "john@smith.com",
    name : "John",
    current_password : "apassw0rd"
    password : "anewpassw0rd",
    password_confirmation : "anewpassw0rd"
  }
}
Success Response	What should the status code be on success and is there any returned data? This is useful when people need to to know what their callbacks should expect! 
Example: 
Code: 200 
Content: { id : 12 }
Error Response	Most endpoints will have many ways they can fail. From unauthorized access, to wrongful parameters etc. All of those should be listed here. It might seem repetitive, but it helps prevent assumptions from being made where they shouldn’t be.
Example: 
Code: 401 UNAUTHORIZED 
Content: { error : "Log in" }
OR
Code: 422 Unprocessable Entry 
Content: { error : "Email invalid" }
Sample Call	Just a sample call to your endpoint in a runnable format ($.ajax call or a curl request) – this makes life easier and more predictable.
$.ajax({
  url: "/users",
  dataType: "json",
  data : { 
    u: { 
      id : 12,
      email : "john@smith.com" 
    }
  },
  type : "PUT",
  success : function(r) {
    console.log(r);
  }
});

Notes	This is where all uncertainties, commentary, discussion etc. can go. I recommend timestamping and identifying oneself when leaving comments here.

Порождающие (creational patterns)Abstract Factory (Абстрактная Фабрика)Предоставляет клиенту интерфейс для создания семейств  взаимосвязанных или взаимозависимых объектов, при этом скрывает от клиента информацию о конкретных классах этих объектов.  
An interface is responsible for creating a factory of related objects without explicitly specifying their classes. Each generated factory can give the objects as per the Factory pattern.Builder (Строитель)Помогает организовать пошаговое построение сложного объекта-продукта так, что клиенту не требуется понимать последовательность шагов и внутреннее устройство строящегося объекта-продукта, при этом в результате одного и того же процесса конструирования могут получаться объекты-продукты с различным представлением (внутренним устройством).
Builder pattern builds a complex object using simple objects and using a step by step approach.Factory Method (Фабричный Метод)Предоставляет абстрактный интерфейс для создания объекта-продукта, но оставляет возможность, разработчикам классов, реализующих этот интерфейс самостоятельно принять решение о том, экземпляр какого конкретного класса-продукта создать. Паттерн Factory Method позволяет базовым абстрактным классам передать ответственность за создание объектов-продуктов своим производным классам.
In Factory pattern, we create object without exposing the creation logic to the client and refer to newly created object using a common interface.Prototype (Прототип)Предоставляет возможность создания новых объектов-продуктов (клонов), используя технику клонирования (копирования) созданного ранее объекта-оригинала-продукта (прототипа). Позволяет задать различные виды (классы-виды) объектов-продуктов (клонов), через настройку состояния каждого нового созданного клона. Классификация клонов-продуктов производится на основании различия их состояний.
This pattern involves implementing a prototype interface which tells to create a clone of the current object. This pattern is used when creation of object directly is costly.Singleton (Одиночка)Гарантирует, что класс имеет только один экземпляр и предоставляет глобальную точку доступа к нему.
This pattern involves a single class which is responsible to create an object while making sure that only single object gets created. This class provides a way to access its only object which can be accessed directly without need to instantiate the object of the class.Структурные (structural patterns)Adapter (Адаптер)Конвертирует интерфейс класса в другой интерфейс, ожидаемый клиентом. Позволяет классам с разными интерфейсами работать вместе.
This pattern involves a single class which is responsible to join functionalities of independent or incompatible interfaces.Bridge (Мост)Разделяет абстракцию и реализацию так, чтобы они могли изменяться независимо.
This pattern involves an interface which acts as a bridge which makes the functionality of concrete classes independent from interface implementer classes.Composite (Компоновщик)Составляет из объектов древовидные структуры для представления иерархий «часть – целое». Позволяет клиентам единообразно трактовать индивидуальные объекты (листья) и составные объекты (ветки).
This pattern creates a class that contains group of its own objects. This class provides ways to modify its group of same objects.Decorator (Декоратор)Динамически предоставляет объекту дополнительные возможности. Представляет собой гибкую альтернативу наследованию для расширения функциональности.
Decorator pattern allows a user to add new functionality to an existing object without altering its structure.Facade (Фасад)Предоставляет унифицированный интерфейс вместо интерфейса некоторой подсистемы (набора взаимосвязанных классов или объектов).  Определяет высокоуровневый интерфейс, делая подсистему проще для использования.
Facade pattern hides the complexities of the system and provides an interface to the client using which the client can access the system.Flyweight (Приспособленец)Описывает правильное применение техники создания «разделяемых объектов», для получения возможности эффективного использования большого числа объектов.
Flyweight pattern tries to reuse already existing similar kind objects by storing them and creates new object when no matching object is found.Proxy (Заместитель)Предоставляет объект-заместитель для контроля доступа к другому объекту.
In proxy pattern, a class represents functionality of another class. This type of design pattern comes under structural pattern.Поведенческие (behavioral patterns)Chain of Responsibility (Цепочка Обязанностей)Cвязывает в цепочку объекты-получатели запроса и передает запрос вдоль этой цепочки, пока один из объектов, составляющих эту цепочку не обработает передаваемый запрос.
Creates a chain of receiver objects for a request.Command (Команда)Позволяет представить запрос в виде объекта, позволяя клиенту конфигурировать запрос (задавая параметры для его обработки), ставить запросы в очередь, протоколировать запросы, а также поддерживать отмену операций.
A request is wrapped under an object as command and passed to invoker object. Invoker object looks for the appropriate object which can handle this command and passes the command to the corresponding object which executes the command.Interpreter (Интерпретатор)Позволяет сформировать объектно-ориентированное представление грамматики для заданного языка, а также описывает правила создания механизма интерпретации (толкования) предложений этого языка.
Interpreter pattern provides a way to evaluate language grammar or expression.  This pattern involves implementing an expression interface which tells to interpret a particular context.Iterator (Итератор)Предоставляет удобный и безопасный способ доступа к элементам коллекции (составного объекта), при этом не раскрывая внутреннего представления этой коллекции.
This pattern is used to get a way to access the elements of a collection object in sequential manner without any need to know its underlying representation.Mediator (Посредник)Предоставляет объект-посредник, скрывающий способ взаимодействия множества других объектов-коллег.
Mediator pattern is used to reduce communication complexity between multiple objects or classes. This pattern provides a mediator class which normally handles all the communications between different classes and supports easy maintenance of the code by loose coupling.Memento (Хранитель)Не нарушая инкапсуляции, фиксирует и выносит за пределы объекта-хозяина его внутреннее состояние так, чтобы позднее это вынесенное состояние можно было восстановить в исходном объекте-хозяине.
Memento pattern is used to restore state of an object to a previous state. Observer (Наблюдатель)Использует связь отношения зависимости «один ко многим» (один издатель ко многим подписчикам). При изменении состояния одного объекта (издателя), все зависящие от него объекты (подписчики) оповещаются об этом и автоматически обновляются.
Observer pattern is used when there is one-to-many relationship between objects such as if one object is modified, its depenedent objects are to be notified automatically.State (Состояние)Позволяет объекту изменять свое поведение в зависимости от своего состояния
In State pattern, we create objects which represent various states and a context object whose behavior varies as its state object changes.Strategy (Стратегия)Определяет набор алгоритмов (часто схожих по роду деятельности), инкапсулирует каждый из имеющихся алгоритмов (в отдельный класс) и делает их подменяемыми. Паттерн Strategy позволяет подменять алгоритмы без участия клиентов, которые используют эти алгоритмы.
In Strategy pattern, a class behavior or its algorithm can be changed at run time. We create objects which represent various strategies and a context object whose behavior varies as per its strategy object. The strategy object changes the executing algorithm of the context object.Template Method (Шаблонный Метод)Формирует структуру алгоритма и позволяет в производных классах реализовать, перекрыть или переопределить определенные шаги алгоритма, не изменяя структуру алгоритма в целом.  
In Template pattern, an abstract class exposes defined way(s)/template(s) to execute its methods. Its subclasses can override the method implementation as per need but the invocation is to be in the same way as defined by an abstract class.Visitor (Посетитель)Позволяет единообразно обойти набор элементов с разнородными интерфейсами (т.е. набор объектов разных классов не приводя их к общему базовому типу), а также позволяет добавить новый метод (функцию) в класс объекта, при этом не изменяя сам класс этого объекта.
In Visitor pattern, we use a visitor class which changes the executing algorithm of an element class. By this way, execution algorithm of element can vary as and when visitor varies. This pattern comes under behavior pattern category. As per the pattern, element object has to accept the visitor object so that visitor object handles the operation on the element object.
