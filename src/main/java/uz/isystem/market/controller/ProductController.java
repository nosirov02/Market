package uz.isystem.market.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.isystem.market.dto.ProductDto;
import uz.isystem.market.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    // |- Done: create function -|
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProductDto productDto){
        return ResponseEntity.ok(productService.create(productDto));
    }


    // |- Done: getAll function -|
    @GetMapping("/get-all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(productService.getAll());
    }


    // |- TODO: getOne function -|
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getOne(@PathVariable("id") Integer id){
        return ResponseEntity.ok(productService.getOne(id));
    }


    // |- TODO: update function -|


    // |- TODO: delete function -|
}
