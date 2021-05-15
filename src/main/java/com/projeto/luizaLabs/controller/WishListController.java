package com.projeto.luizaLabs.controller;



import com.projeto.luizaLabs.entity.Produto;
import com.projeto.luizaLabs.service.WishListService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.projeto.luizaLabs.entity.Cliente;
import com.projeto.luizaLabs.entity.WishList;
import com.projeto.luizaLabs.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api")
public class WishListController {

    @Autowired
    private WishListService wishlistService;

    @ApiOperation(value="Adicionar um produto na wishlist")
    @ApiResponses(value={
            @ApiResponse(code=201,message= "Foi adicionado um novo produto na sua wishlist",response= Response.class),
            @ApiResponse(code=400,message="Requisição inválida",response=Response.class)
    })
    @PostMapping("/wishlist")
    public ResponseEntity<WishList> adicionarProdutoNaWishlist(@RequestBody WishList wishlist) {
        try {
            WishList respostaWishList = wishlistService.adicionarWishList(wishlist);
            return new ResponseEntity<>(wishlistService.adicionarWishList(wishlist), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @ApiOperation(value="Retornar um produto da wishlist")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Produto da wishlist retornado com sucesso",response= Response.class),
            @ApiResponse(code=400,message="Requisição inválida",response=Response.class)
    })
    @GetMapping("/wishlist/{id}")
    public ResponseEntity<?> buscarProdutosNaWishlist(@PathVariable long id_produto) {
        try{
            return  new ResponseEntity<>(wishlistService.buscarProductoWishlist(id_produto),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/wishlist/{id}")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Produto da wishlist retornado com sucesso",response= Response.class),
            @ApiResponse(code=400,message="Requisição inválida",response=Response.class)
    })
    public ResponseEntity<?> visualizarProdutosNaWishlist(@PathVariable long id_cliente){
        try{
            WishList existeCliente= wishlistService.buscarClienteWishlist(id_cliente);
            return new ResponseEntity<>(wishlistService.)
        }
        catch (Exception e){

        }
    }

//    @ApiOperation(value = "Atualizar um produto na WishList")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Produto da wishlist retornado com sucesso", response = Response.class),
//            @ApiResponse(code = 404, message = "Produto não encontrado na wishlist", response = Response.class),
//            @ApiResponse(code = 400, message = "Requisição inválida", response = Response.class)
//    })
//    @PutMapping("/wishlist/{id}")
//    public ResponseEntity<WishList> atualizarProdutoNaWishlist(@PathVariable long id, WishList wishList) {
//        try {
//            Optional<WishList> wishlistPosBusca = wishlistService.buscarWishListId(id);
//            if (wishlistPosBusca.isPresent()) {
//                wishList.setId(wishlistPosBusca.get().getId());
//                return new ResponseEntity<>(wishlistService.atualizarWishList(wishList), HttpStatus.NOT_FOUND);
//            }
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//
//        }
//
//    }


    @ApiOperation(value = "Deletar um produto na WishList")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Produto da wishlist deletado com sucesso", response = Response.class),
            @ApiResponse(code = 404, message = "Produto não encontrado na wishlist", response = Response.class),
            @ApiResponse(code = 400, message = "Requisição inválida", response = Response.class)
    })
    @DeleteMapping("/wishlist/{id_produto}/{id_cliente}")
    public ResponseEntity<WishList> removerProdutoNaWishlist(@PathVariable long id_produto,@PathVariable long id_cliente){
     Optional<Produto> existeProduto = pr
    }

}