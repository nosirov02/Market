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


    // |- TODO: create function -|
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProductDto productDto){
        return ResponseEntity.ok(productService.create(productDto));
    }


    // |- TODO: getAll function -|



    // |- TODO: getOne function -|


    // |- TODO: update function -|


    // |- TODO: delete function -|
}
