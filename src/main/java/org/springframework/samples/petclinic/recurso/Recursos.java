package org.springframework.samples.petclinic.recurso;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.recurso.enums.TipoRecurso;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recursos")
public class Recursos extends BaseEntity {

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private TipoRecurso nombre;

    @NotNull
    private Integer cantidadBase;

    public void addRecurso(TipoRecurso recurso, Integer cantidad) throws Exception {
		String resourceName = this.getRecurso(recurso);

		cantidad += this.getRecursosAmount(recurso);

		java.lang.reflect.Method setter = this.getClass().getMethod("set" + resourceName, Integer.class);
		cantidad = cantidad < 0 ? 0:cantidad;
		setter.invoke(this, cantidad);
	}

    private String getRecurso(TipoRecurso recurso){
		String methodName = recurso.toString().toLowerCase();
		methodName = methodName.substring(0,1).toUpperCase() + methodName.substring(1, methodName.length());
		return methodName;
	}

    public Integer getRecursosAmount(TipoRecurso recurso) throws Exception {
		String nombreRecurso = this.getRecurso(recurso);
		java.lang.reflect.Method getter = this.getClass().getMethod("get" + nombreRecurso);
		return (Integer)getter.invoke(this);
	}
    
}
