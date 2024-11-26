/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import excepciones.DAOException;

/**
 *
 * @author diana
 */
    public class ComentarioBO implements IComentarioBO {

  
    private final IComentarioDAO comentarioDAO; 
    private final ComentarioCVR comentarioCVR; 

    public ComentarioBO() {
        this.comentarioDAO = new ComentarioDAO();
        this.comentarioCVR = new ComentarioCVR();
    }

    /**
     * Método para agregar un nuevo comentario.
     *
     * @param comentarioDTO Objeto de tipo ComentarioDTO que se desea agregar.
     * @throws BusinessException Arroja una excepción si ocurre un error en la
     * operación.
     */
    @Override
    public void agregar(ComentarioDTO comentarioDTO) throws BusinessException {
        try {
            
            this.comentarioDAO.agregar(comentarioCVR.convertir_Comentario(comentarioDTO));
        } catch (DAOException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    /**
     * Método que nos permite obtener un comentario buscándolo mediante su id.
     *
     * @param id Id del comentario a buscar.
     * @return Retorna un objeto de tipo ComentarioDTO.
     * @throws BusinessException Arroja una excepción si ocurre un error en la
     * operación.
     */
    @Override
    public ComentarioDTO buscarPorId(int id) throws BusinessException {
        try {
            return comentarioCVR.convertir_DTO(this.comentarioDAO.buscarPorId(id));
        } catch (DAOException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<ComentarioDTO> listaPaginada(int offset, int limit) throws BusinessException {
        try {
            List<Comentario> lista = comentarioDAO.listaPaginada(offset, limit);
            List<ComentarioDTO> listaDTO = new ArrayList<>();
            for (int i = 0; i < lista.size(); i++) {
                listaDTO.add(comentarioCVR.convertir_DTO(lista.get(i)));
            }
            return listaDTO;
        } catch (DAOException ex) {
            throw new BusinessException(ex.getMessage());
        }
    }

    @Override
    public List<ComentarioDTO> listaPorFecha(LocalDateTime begin, LocalDateTime end) throws BusinessException {
        try {
            List<Comentario> lista = comentarioDAO.listaPorFecha(begin, end);
            List<ComentarioDTO> listaDTO = new ArrayList<>();
            for (int i = 0; i < lista.size(); i++) {
                listaDTO.add(comentarioCVR.convertir_DTO(lista.get(i)));
            }
            return listaDTO;
        } catch (DAOException ex) {
            throw new BusinessException(ex.getMessage());
        }
    }
}

}
