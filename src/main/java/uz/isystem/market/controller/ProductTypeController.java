package uz.isystem.market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.isystem.market.dto.ProductTypeDto;
import uz.isystem.market.service.ProductTypeService;

import java.util.List;

@RestController
@RequestMapping("api/product-type")
public class ProductTypeController {
    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping("/id")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        ProductTypeDto result = productTypeService.get(id);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> findAll() {
        List<ProductTypeDto> result = productTypeService.findAll();
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProductTypeDto dto){
        ProductTypeDto result = productTypeService.create(dto);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id")Integer id,
                                    @RequestBody ProductTypeDto dto){
        ProductTypeDto result = productTypeService.update(id, dto);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        Boolean result = productTypeService.delete(id);
        return ResponseEntity.ok(result);
    }
}
