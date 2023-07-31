# Personnal Management System

Personnal Management System, Java Spring Boot ve PostgreSQL kullanılarak geliştirilmiş bir projedir. Bu proje, şirketler ve çalışanlar için CRUD (Create, Read, Update, Delete) işlemlerini yapmak üzere tasarlanmıştır. Projede Lombok ve Mapstruct kütüphaneleri kullanılmıştır. Swagger entegre edilmiş olup API belgelerine erişim sağlar.

## Gereksinimler

- Java 17
- PostgreSQL veritabanı
- Maven
- Bir REST API test aracı (örneğin, Postman)

## Kurulum

1. Bu repoyu klonlayın veya ZIP olarak indirin.
2. PostgreSQL veritabanında bir veritabanı oluşturun.
3. application.properties dosyasında veritabanı bağlantı ayarlarınızı güncelleyin.

## Başlatma

1. Proje kök dizininde terminal açın.
2. `mvn clean install` komutunu çalıştırarak bağımlılıkları indirin ve projeyi derleyin.
3. `mvn spring-boot:run` komutu ile uygulamayı başlatın.

## API Dökümantasyonu

Uygulama başlatıldıktan sonra, Swagger dökümantasyonuna erişmek için aşağıdaki URL'yi kullanabilirsiniz:
http://localhost:8080/swagger-ui/

Bu dökümantasyonda tüm API endpointleri ve parametreleri detaylı bir şekilde belirtilmiştir. Dökümantasyonu inceleyerek, her bir endpointin nasıl kullanılacağı hakkında bilgi edinebilirsiniz.

## Kullanım

Uygulamayı başlattıktan sonra, /employee ve /company endpointlerine HTTP istekleri yaparak CRUD operasyonları gerçekleştirebilirsiniz. İşte temel kullanım örnekleri:

1. Çalışanları listeleme:
   - Endpoint: GET /employee
   - Tüm çalışanları listeler.

2. Yeni çalışan ekleme:
   - Endpoint: POST /employee
   - Request Body: Eklenecek çalışanın bilgilerini içeren JSON verisi.
   
3. Çalışan güncelleme:
   - Endpoint: PUT /employee/{id}
   - Request Body: Güncellenecek çalışanın güncel bilgilerini içeren JSON verisi.
   
4. Çalışan silme:
   - Endpoint: DELETE /employee/{id}
   - Belirtilen ID'ye sahip çalışanı siler.

5. Şirketleri listeleme:
   - Endpoint: GET /company
   - Tüm şirketleri listeler.

6. Yeni şirket ekleme:
   - Endpoint: POST /company
   - Request Body: Eklenecek şirketin bilgilerini içeren JSON verisi.
   
7. Şirket güncelleme:
   - Endpoint: PUT /company/{id}
   - Request Body: Güncellenecek şirketin güncel bilgilerini içeren JSON verisi.
   
8. Şirket silme:
   - Endpoint: DELETE /company/{id}
   - Belirtilen ID'ye sahip şirketi siler.

## Katmanlar

Uygulama, şu katmanlardan oluşur:

- Model: Veritabanı tabloları ve ilişkili entity sınıfları.
- Controller: HTTP isteklerini yöneten ve doğru Service metodlarına yönlendiren katman.
- Service: İş mantığının yer aldığı katman. Repository'den veri alır ve işlemleri gerçekleştirir.
- Repository: Veritabanı işlemlerini yürüten katman.
- Mapper: Entity ve DTO (Data Transfer Object) sınıfları arasında dönüşümleri sağlayan katman.
- DTO: Veri transferi için kullanılan veri nesnelerinin (Data Transfer Object) yer aldığı katman.
- Exception: Uygulama tarafından fırlatılan özel istisna sınıflarının bulunduğu katman.

## Lisans

Bu proje MIT Lisansı altında lisanslanmıştır. Daha fazla bilgi için [LICENSE](LICENSE) dosyasını inceleyebilirsiniz.
