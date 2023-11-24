# www_tuan5

![image](https://github.com/TrietKun/www_tuan5/assets/103935961/0d22c06b-1124-4016-ae0a-a1fb478ff236)

Các dependencies của project như sau

```
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
implementation 'org.springframework.boot:spring-boot-starter-web'
implementation 'org.springframework.boot:spring-boot-starter-web-services'
implementation 'org.mariadb.jdbc:mariadb-java-client:3.2.0'
compileOnly 'org.projectlombok:lombok'
developmentOnly 'org.springframework.boot:spring-boot-devtools'
annotationProcessor 'org.projectlombok:lombok'
//for country code
implementation 'com.neovisionaries:nv-i18n:1.29'
//For database REST
implementation 'org.springframework.data:spring-data-rest-core:4.1.4'
testImplementation 'org.springframework.boot:spring-boot-starter-test'
testImplementation 'org.springframework.security:spring-security-test'
```

<h2>LOAD DỮ LIỆU CÓ PHÂN TRANG</h2>
Trong lớp CandidateController ta thêm phương thức như sau:

```
  @GetMapping("/candidates")
  public String showCandidateListPaging(Model model,
  @RequestParam("page") Optional<Integer> page,
  @RequestParam("size") Optional<Integer> size) {
  int currentPage = page.orElse(1);
  int pageSize = size.orElse(10);
  Page<Candidate> candidatePage= candidateServices.findPaginated(
  PageRequest.of(currentPage - 1, pageSize)
  );
  model.addAttribute("candidatePage", candidatePage);
  int totalPages = candidatePage.getTotalPages();
  if (totalPages > 0) {List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
  .boxed()
  .collect(Collectors.toList());
  model.addAttribute("pageNumbers", pageNumbers);
  }
  return "candidates/candidates-paging";
  }
```

![image](https://github.com/TrietKun/www_tuan5/assets/103935961/2e27fafe-2c3f-46f9-ad9d-dd04b492e51f)


<h2>L
OAD DỮ LIỆU KHÔNG PHÂN TRANG</h2>
Trong gói front-end, ta thêm các gói như hình 4. Code cho CandidateController tham khảo như sau

```
package vn.edu.iuh.fit.frontend.controllers;
@Controller
public class CandidateController {
@Autowired
private CandidateRepository candidateRepository;
@Autowired
private CandidateServices candidateServices;
@GetMapping("/list")
public String showCandidateList(Model model) {
model.addAttribute("candidates", candidateRepository.findAll());
return "candidates/candidates";
}
```

![image](https://github.com/TrietKun/www_tuan5/assets/103935961/04e04081-e817-4c90-9bf3-9a1d0d88c2f7)


